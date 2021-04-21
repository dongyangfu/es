package com.es.manager.service.impl;

import com.es.common.constant.UserConstants;
import com.es.common.core.domain.entity.SysUser;
import com.es.common.core.text.Convert;
import com.es.common.exception.BusinessException;
import com.es.common.utils.PeriodUtil;
import com.es.common.utils.StringUtils;
import com.es.common.utils.bean.BeanUtils;
import com.es.common.utils.security.Md5Utils;
import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.dto.StudentDTOSuper;
import com.es.manager.domain.vo.StudentVO;
import com.es.manager.mapper.ManagerStudentMapper;
import com.es.manager.service.ManagerStudentService;
import com.es.system.domain.SysUserRole;
import com.es.system.mapper.SysUserMapper;
import com.es.system.mapper.SysUserRoleMapper;
import com.es.system.service.ISysConfigService;
import com.es.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: fudy
 * @date: 2021/4/10 下午 04:00
 * @Decription:
 **/
@Service
public class ManagerStudentServiceImpl implements ManagerStudentService {

    private static final Logger log = LoggerFactory.getLogger(ManagerStudentServiceImpl.class);


    @Resource
    private ManagerStudentMapper managerStudentMapper;

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysConfigService configService;

    @Override
    public List<StudentVO> getStudentList(StudentDTO studentDTO) {
        // TODO 由于浏览器缓存，现在需要转化格式
        if (studentDTO.getStuNum() == null){
            studentDTO.setStuNum(studentDTO.getPhonenumber());
        }
        if (studentDTO.getUserName() == null){
            studentDTO.setUserName(studentDTO.getLoginName());
        }
        return managerStudentMapper.getStudentList(studentDTO);
    }

    @Override
    public List<StudentVO> getStudentScoreList(StudentDTO studentDTO) {
        return managerStudentMapper.getStudentScoreList(studentDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertStudent(StudentDTO studentDTO) {
        // 新增用户信息
        int rows = userMapper.insertUser(studentDTO);
        // 新增用户与角色管理
        insertUserRole(studentDTO.getUserId(), studentDTO.getRoleIds());
        // 新增学生信息
        // 根据当前时间筛选出今年的学生，如果是21届，2022年春天才会选拔，
        studentDTO.setStuPeriod(PeriodUtil.getNowPeriod());
        int i = managerStudentMapper.insertStudent(studentDTO);
        rows += i;
        return rows;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStudentById(StudentDTO studentDTO) {
        studentDTO.setStuTel(studentDTO.getPhonenumber());
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(studentDTO.getUserId());
        // 修改用户信息
        int sum = userMapper.updateUser(studentDTO);
        // 新增用户与角色管理
        insertUserRole(studentDTO.getUserId(), studentDTO.getRoleIds());
        // 修改学生信息
        return sum + managerStudentMapper.updateStudentById(studentDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStudentScoreById(StudentDTO studentDTO) {
        return managerStudentMapper.updateStudentScoreById(studentDTO);
    }

    @Override
    public int updateStudent(StudentDTO studentDTO) {
        return managerStudentMapper.updateStudent(studentDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteStudentByIds(String ids) {
        Long[] userIds = Convert.toLongArray(ids);
        for (Long userId : userIds) {
            sysUserService.checkUserAllowed(new SysUser(userId));
        }
        // 删除用户与角色关联
        userRoleMapper.deleteUserRole(userIds);
        // 删除用户信息
        userMapper.deleteUserByIds(userIds);
        // 删除学生信息
        return managerStudentMapper.deleteStudentByIds(userIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importUser(List<StudentDTOSuper> userList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (StudentDTOSuper user1 : userList) {
            try {
                StudentDTO user = new StudentDTO();
                BeanUtils.copyProperties(user1, user);
                user.setcScore(user1.getCcScore());
                user.setStuId(user.getUserId());
                user.setStuName(user.getUserName());
                user.setStuTel(user.getPhonenumber());
                // 验证是否存在这个用户
                SysUser u = userMapper.selectUserByLoginName(user.getLoginName());
                if (StringUtils.isNull(u)) {
                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
                    user.setCreateBy(operName);
                    this.insertStudent(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getStuId() + " 导入成功");
                } else if (isUpdateSupport) {
                    user.setUpdateBy(operName);
                    this.updateStudentById(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getStuId() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getStuId() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user1.getUserId() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public String checkStuNumUnique(StudentDTO studentDTO) {
        long userId = StringUtils.isNull(studentDTO.getUserId()) ? -1L : studentDTO.getUserId();
        studentDTO.setStuId(userId);
        StudentVO info = managerStudentMapper.checkStuNumUnique(studentDTO);
        if (StringUtils.isNotNull(info) && info.getStuId() != userId) {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    @Override
    public Long[] firstProcessStuIds( int number) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setProcessPersonNum(number);
        studentDTO.setStuPeriod(PeriodUtil.getNowPeriod());
        List<StudentVO> studentVOS = managerStudentMapper.firstProcessStuIds(studentDTO);
        List<Long> collect = studentVOS.stream().map(StudentVO::getStuId).collect(Collectors.toList());
        Long [] result = new Long[collect.size()];
        return collect.toArray(result);
    }

    @Override
    public Long[] twoProcessStuIds(int number) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setProcessPersonNum(number);
        studentDTO.setStuPeriod(PeriodUtil.getNowPeriod());
        List<StudentVO> studentVOS = managerStudentMapper.twoProcessStuIds(studentDTO);
        List<Long> collect = studentVOS.stream().map(StudentVO::getStuId).collect(Collectors.toList());
        Long [] result = new Long[collect.size()];
        return collect.toArray(result);
    }

    @Override
    public int updateStudentByIds(StudentDTO studentDTO) {
        return managerStudentMapper.updateStudentByIds(studentDTO);
    }

    @Override
    public int updateStudentNotByIds(StudentDTO studentDTO) {
        return managerStudentMapper.updateStudentNotByIds(studentDTO);
    }

    public void insertUserRole(Long userId, Long[] roleIds) {
        if (StringUtils.isNotNull(roleIds)) {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<SysUserRole>();
            for (Long roleId : roleIds) {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (list.size() > 0) {
                userRoleMapper.batchUserRole(list);
            }
        }
    }

}
