package com.es.manager.service.impl;

import com.es.common.constant.TeacherProfessTypeEnum;
import com.es.common.constant.UserConstants;
import com.es.common.core.domain.entity.SysRole;
import com.es.common.core.domain.entity.SysUser;
import com.es.common.core.text.Convert;
import com.es.common.exception.BusinessException;
import com.es.common.utils.StringUtils;
import com.es.common.utils.bean.BeanUtils;
import com.es.common.utils.security.Md5Utils;
import com.es.manager.domain.dto.TeacherDTO;
import com.es.manager.domain.dto.TeacherDTOSuper;
import com.es.manager.domain.vo.TeaCourseVO;
import com.es.manager.domain.vo.TeacherVO;
import com.es.manager.mapper.ManagerTeacherMapper;
import com.es.manager.service.ManagerTeacherService;
import com.es.system.domain.SysUserRole;
import com.es.system.mapper.SysUserMapper;
import com.es.system.mapper.SysUserRoleMapper;
import com.es.system.service.ISysConfigService;
import com.es.system.service.ISysRoleService;
import com.es.system.service.ISysUserService;
import com.es.teacher.domain.TeaCourse;
import com.es.teacher.domain.TeaUserCourse;
import com.es.teacher.mapper.TeaCourseMapper;
import com.es.teacher.service.ITeaCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author: fudy
 * @date: 2021/3/27 下午 12:15
 * @Decription: 管理员管理教师接口
 **/
@Service
public class ManagerTeacherServiceImpl implements ManagerTeacherService {

    private static final Logger log = LoggerFactory.getLogger(ManagerTeacherServiceImpl.class);

    @Resource
    private ManagerTeacherMapper managerTeacherMapper;

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private SysUserRoleMapper userRoleMapper;
    @Resource
    private TeaCourseMapper teaCourseMapper;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ITeaCourseService teaCourseService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysConfigService configService;


    @Override
    public List<TeacherVO> getTeacherList(TeacherDTO teacherDTO) {
        List<TeacherVO> teacherList = managerTeacherMapper.getTeacherList(teacherDTO);
        teacherList.forEach(t -> {
            if (Objects.nonNull(t.getTeaProfess())) {
                t.setTeacherProfessName(TeacherProfessTypeEnum.convertOrderChannelEnum(t.getTeaProfess().intValue()).getMessage());
            }
            // 存入教师特长
            List<TeaCourse> teaCourses = teaCourseMapper.selectTeaCourseById(t.getTeaId());
            t.setCourses(teaCourses);
        });
        return teacherList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertTeacher(TeacherDTO teacherDTO) {
        // 新增用户信息
        int rows = userMapper.insertUser(teacherDTO);
        // 新增用户与角色管理
        isTeacherRole(teacherDTO);
        if (teacherDTO.getCourses() != null) {
            // 增加教师特长
            insertTeaCourse(teacherDTO.getUserId(), teacherDTO.getCourses());
        }
        // 新增教师信息
        int i = managerTeacherMapper.insertTeacher(teacherDTO);
        rows += i;
        return rows;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateTeacherById(TeacherDTO teacherDTO) {
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(teacherDTO.getUserId());
        // 删除教师特长
        teaCourseMapper.deleteTeaCourse(teacherDTO.getTeaId());
        // 增加教师特长
        insertTeaCourse(teacherDTO.getUserId(), teacherDTO.getCourses());
        // 修改用户信息
        int sum = userMapper.updateUser(teacherDTO);
        // 新增用户与角色管理
        isTeacherRole(teacherDTO);
        // 修改教师信息
        return sum + managerTeacherMapper.updateTeacherById(teacherDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteTeacherByIds(String ids) {
        Long[] userIds = Convert.toLongArray(ids);
        for (Long userId : userIds) {
            sysUserService.checkUserAllowed(new SysUser(userId));
        }
        // 删除用户与角色关联
        userRoleMapper.deleteUserRole(userIds);
        // 删除教师特长
        teaCourseMapper.deleteCourseByIds(userIds);
        // 删除用户信息
        userMapper.deleteUserByIds(userIds);
        // 删除教师信息
        return managerTeacherMapper.deleteTeacherByIds(userIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importUser(List<TeacherDTOSuper> userList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (TeacherDTOSuper user1 : userList) {
            try {
                TeacherDTO user = new TeacherDTO();
                BeanUtils.copyProperties(user1, user);
                user.setTeaId(user.getUserId());
                user.setTeaProfess((long) TeacherProfessTypeEnum.convertOrderChannelEnum(user.getTeacherProfessName()).getCode());
                // 验证是否存在这个用户
                SysUser u = userMapper.selectUserByLoginName(user.getLoginName());
                if (StringUtils.isNull(u)) {
                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
                    user.setCreateBy(operName);
                    this.insertTeacher(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getTeaId() + " 导入成功");
                } else if (isUpdateSupport) {
                    user.setUpdateBy(operName);
                    this.updateTeacherById(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getTeaId() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getTeaId() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user1.getTeaId() + " 导入失败：";
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
    public String checkTeaJobNumberUnique(String teaJobNumber) {
        int count = managerTeacherMapper.checkTeaJobNumberUnique(teaJobNumber);
        if (count > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    @Override
    public List<Map<String, Object>> getAllCourseOfTeaFlag(Long teaId) {
        List<Map<String, Object>> maps = teaCourseService.selectTeaCourseName();
        List<TeaCourseVO> teaCourseVOS = teaCourseService.selectAllTeaCourseById(teaId);
        HashSet<String> set = new HashSet<>();
        teaCourseVOS.forEach(x -> set.add(x.getCourseName()));

        for (Map<String, Object> map : maps) {
            if (set.contains(map.get("course_name"))) {
                map.put("flag", true);
            } else {
                map.put("flag", false);
            }
        }
        return maps;
    }

    /**
     * 新增用户角色信息
     *
     * @param
     */
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

    /**
     * 新增教师特色课程
     *
     * @param courses
     */
    public void insertTeaCourse(Long userId, Long[] courses) {
        if (StringUtils.isNotNull(courses)) {
            // 新增用户与角色管理
            List<TeaUserCourse> list = new ArrayList();
            for (Long course : courses) {
                TeaUserCourse ur = new TeaUserCourse();
                ur.setTeaId(userId);
                ur.setCourseId(course);
                list.add(ur);
            }
            if (list.size() > 0) {
                teaCourseMapper.batchTeaCourse(list);
            }
        }
    }

    private void isTeacherRole(TeacherDTO teacherDTO) {
        if (teacherDTO.getRoleIds() != null) {
            insertUserRole(teacherDTO.getUserId(), teacherDTO.getRoleIds());
            Long[] roleIds = teacherDTO.getRoleIds();
            for (int i = 0; i < roleIds.length; i++) {
                SysRole sysRole = roleService.selectRoleById(roleIds[i]);
                if (sysRole.getRoleName().contains("卓越班班主任")) {
                    teacherDTO.setCharge(1);
                    continue;
                }
                if (sysRole.getRoleName().contains("机试教师")) {
                    teacherDTO.setComputer(1);
                    continue;
                }
                if (sysRole.getRoleName().contains("面试教师")) {
                    teacherDTO.setInterview(1);
                }
            }
        }
    }
}
