package com.es.manager.service;

import com.es.manager.domain.dto.TeacherDTO;
import com.es.manager.domain.vo.TeacherVO;
import com.es.teacher.domain.TeaUser;

import java.util.List;

/**
 * @author: fudy
 * @date: 2021/3/27 下午 12:13
 * @Decription: 管理员管理教师接口
 **/
public interface ManagerTeacherService {

    /**
     * 获取教师信息列表
     *
     * @param teacherDTO 获取教师信息入参
     * @return com.es.manager.domain.vo.TeacherVO
     */
    List<TeacherVO> getTeacherList(TeacherDTO teacherDTO);

    /**
     * 增加老师信息
     *
     * @param teacherDTO 老师信息
     */
    int insertTeacher(TeacherDTO teacherDTO);

    /**
     * 修改老师信息
     *
     * @param teacherDTO 老师信息
     */
    int updateTeacherById(TeacherDTO teacherDTO);

    /**
     * 删除多个老师信息
     *
     * @param ids 老师id
     */
    int deleteTeacherByIds(String ids);

    /**
     * 导入用户数据
     *
     * @param userList        用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    String importUser(List<TeaUser> userList, Boolean isUpdateSupport, String operName);


    /**
     * 校验教师工号是否唯一
     *
     * @param teaJobNumber 教师工号
     * @return 结果
     */
    String checkTeaJobNumberUnique(String teaJobNumber);

}
