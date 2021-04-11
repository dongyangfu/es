package com.es.manager.mapper;

import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.dto.StudentDTOSuper;
import com.es.manager.domain.vo.StudentVO;

import java.util.List;
import java.util.Map;

/**
 * @author: fudy
 * @date: 2021/4/10 下午 04:00
 * @Decription:
 **/

public interface ManagerStudentMapper {
    /**
     * 获取教师信息列表
     *
     * @param StudentDTO 获取教师信息入参
     * @return com.es.manager.domain.vo.StudentVO
     */
    List<StudentVO> getStudentList(StudentDTO StudentDTO);

    /**
     * 增加老师信息
     *
     * @param StudentDTO 老师信息
     */
    int insertStudent(StudentDTO StudentDTO);

    /**
     * 修改老师信息
     *
     * @param StudentDTO 老师信息
     */
    int updateStudentById(StudentDTO StudentDTO);

    /**
     * 删除多个老师信息
     *
     * @param ids 老师id
     */
    int deleteStudentByIds(Long[] ids);

    /**
     * 导入用户数据
     *
     * @param userList        用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    String importUser(List<StudentDTOSuper> userList, Boolean isUpdateSupport, String operName);


    /**
     * 检验学生学号是否唯一
     *
     * @param studentDTO 学生学号
     * @return  int
     */
    StudentVO checkStuNumUnique(StudentDTO studentDTO);
}
