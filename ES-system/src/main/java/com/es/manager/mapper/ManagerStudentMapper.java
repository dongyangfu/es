package com.es.manager.mapper;

import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.dto.StudentDTOSuper;
import com.es.manager.domain.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

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
     * 获取学生成绩
     * @param studentDTO 获取学生成绩
     * @return  List<StudentVO>
     */
    List<StudentVO> getStudentScoreList(StudentDTO studentDTO);

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
     * 修改学生分数信息
     *
     * @param studentDTO 学生信息
     */
    int updateStudentScoreById(StudentDTO studentDTO);

    /**
     * 修改学生分数信息
     *
     * @param studentDTO 学生信息
     */
    int updateStudent(StudentDTO studentDTO);

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

    /**
     * 返回n个进入预选拔的学生
     *
     * @param studentDTO 进入预选拔学生个数
     * @return 选拔成功的学生id
     */
    List<StudentVO> firstProcessStuIds(StudentDTO studentDTO);

    /**
     * 返回n个进入预选拔的学生
     *
     * @param studentDTO 进入面试学生个数
     * @return 选拔成功的学生id
     */
    List<StudentVO> twoProcessStuIds(StudentDTO studentDTO);

    /**
     * 批量修改学生信息
     *
     * @param studentDTO 学生信息
     */
    int updateStudentByIds(StudentDTO studentDTO);

    /**
     * 批量修改学生信息
     *
     * @param studentDTO 学生信息
     */
    int updateStudentNotByIds(StudentDTO studentDTO);
}
