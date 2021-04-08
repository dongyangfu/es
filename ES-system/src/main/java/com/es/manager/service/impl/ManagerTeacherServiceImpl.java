package com.es.manager.service.impl;

import com.alibaba.fastjson.JSON;
import com.es.common.constant.TeacherProfessTypeEnum;
import com.es.common.constant.UserConstants;
import com.es.common.core.domain.entity.SysRole;
import com.es.common.core.page.PageDomain;
import com.es.common.core.page.TableSupport;
import com.es.common.core.text.Convert;
import com.es.common.exception.BusinessException;
import com.es.common.utils.StringUtils;
import com.es.common.utils.bean.BeanUtils;
import com.es.common.utils.sql.SqlUtil;
import com.es.manager.domain.dto.TeacherDTO;
import com.es.manager.domain.vo.TeacherVO;
import com.es.manager.mapper.ManagerTeacherMapper;
import com.es.manager.service.ManagerTeacherService;
import com.es.system.domain.SysUserRole;
import com.es.system.mapper.SysUserMapper;
import com.es.system.mapper.SysUserRoleMapper;
import com.es.system.service.ISysRoleService;
import com.es.teacher.domain.TeaCourse;
import com.es.teacher.domain.TeaUser;
import com.es.teacher.domain.TeaUserCourse;
import com.es.teacher.mapper.TeaCourseMapper;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Resource
    private TeaCourseMapper teaCourseMapper;

    @Autowired
    private ISysRoleService roleService;


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

    @Override
    public int insertTeacher(TeacherDTO teacherDTO) {
        // 新增用户信息
        int rows = userMapper.insertUser(teacherDTO);
        // 新增用户与角色管理
        insertUserRole(teacherDTO.getUserId(), teacherDTO.getRoleIds());
        // 增加教师特长
        insertTeaCourse(teacherDTO.getUserId(), teacherDTO.getCourses());
        teacherDTO.setCharge(0);
        teacherDTO.setComputer(0);
        teacherDTO.setInterview(0);
        Long[] roleIds = teacherDTO.getRoleIds();
        for (int i = 0; i < roleIds.length; i++) {
            SysRole sysRole = roleService.selectRoleById(roleIds[i]);
            if (sysRole.getRoleName().contains("卓越班班主任")){
                teacherDTO.setCharge(1);
                continue;
            }
            if (sysRole.getRoleName().contains("机试批改教师")){
                teacherDTO.setComputer(1);
                continue;
            }
            if (sysRole.getRoleName().contains("面试教师")){
                teacherDTO.setInterview(1);
            }
        }
        // 新增教师信息
        int i = managerTeacherMapper.insertTeacher(teacherDTO);
        rows += i;
        return rows;
    }

    @Override
    public int updateTeacherById(TeacherDTO teacherDTO) {
        return managerTeacherMapper.updateTeacherById(teacherDTO);
    }

    @Override
    public int deleteTeacherByIds(String ids) {
        Long[] userIds = Convert.toLongArray(ids);
        return managerTeacherMapper.deleteTeacherByIds(userIds);
    }

    @Override
    public String importUser(List<TeaUser> userList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (TeaUser user : userList) {
            try {
                // 验证是否存在这个用户
                log.info("入参{}", JSON.toJSONString(user));
                TeaUser u = managerTeacherMapper.getTeacher(user);
                log.info("出参{}", JSON.toJSONString(u));
                if (StringUtils.isNull(u)) {
                    TeacherDTO teacherDTO = new TeacherDTO();
//                    teacherDTO.setTeaJobNumber(user.getTeaJobNumber());
//                    teacherDTO.setTeaId(user.getTeaId());
//                    teacherDTO.setTeaProfess(user.getTeaProfess());
//                    teacherDTO.setStatus(user.getStatus());
                    BeanUtils.copyProperties(user, teacherDTO);
                    managerTeacherMapper.insertTeacher(teacherDTO);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getTeaId() + " 导入成功");
                } else if (isUpdateSupport) {
                    TeacherDTO teacherDTO = new TeacherDTO();
                    BeanUtils.copyProperties(u, teacherDTO);
                    managerTeacherMapper.updateTeacherById(teacherDTO);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getTeaId() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getTeaId() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getTeaId() + " 导入失败：";
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
}
