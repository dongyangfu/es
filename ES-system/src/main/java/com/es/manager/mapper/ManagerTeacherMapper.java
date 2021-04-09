package com.es.manager.mapper;

import com.es.manager.domain.dto.TeacherDTO;
import com.es.manager.domain.vo.TeacherVO;
import com.es.teacher.domain.TeaUser;

import java.util.List;

/**
 * @author: fudy
 * @date: 2021/3/27 下午 12:28
 * @Decription: 管理员管理教师接口
 **/

public interface ManagerTeacherMapper {
    /**
     * 获取教师信息列表
     *
     * @param teacherDTO 获取教师信息入参
     * @return com.es.manager.domain.vo.TeacherVO
     */
    List<TeacherVO> getTeacherList(TeacherDTO teacherDTO);

    /**
     * 获取教师信息列表
     *
     * @param teaUser 获取教师信息入参
     * @return com.es.manager.domain.vo.TeacherVO
     */
    TeaUser getTeacher(TeaUser teaUser);

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
     * @param longs 老师id
     */
    int deleteTeacherByIds(Long[] longs);

    /**
     * 删除一个老师信息
     *
     * @param longs 老师id
     */
    int deleteTeacherById(Long longs);

    /**
     * 判断教师工号是否存在
     *
     * @param teaJobNumber 教师工号
     * @return 结果
     */
    int checkTeaJobNumberUnique(String teaJobNumber);
}
