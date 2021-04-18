package com.es.manager.service;

import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.dto.StudentDTOSuper;
import com.es.manager.domain.vo.StudentVO;

import java.util.List;
import java.util.Map;

/**
 * @author: fudy
 * @date: 2021/4/10 下午 03:58
 * @Decription: 学生信息接口
 **/
public interface ManagerStudentService {
    /**
     * 获取学生信息列表
     *
     * @param studentDTO 获取学生信息入参
     * @return com.es.manager.domain.vo.StudentVO
     */
    List<StudentVO> getStudentList(StudentDTO studentDTO);

    /**
     * 获取学生成绩
     * @param studentDTO 获取学生成绩
     * @return  List<StudentVO>
     */
    List<StudentVO> getStudentScoreList(StudentDTO studentDTO);

    /**
     * 增加学生信息
     *
     * @param studentDTO 学生信息
     */
    int insertStudent(StudentDTO studentDTO);

    /**
     * 修改学生信息
     *
     * @param studentDTO 学生信息
     */
    int updateStudentById(StudentDTO studentDTO);

    /**
     * 修改学生分数信息
     *
     * @param studentDTO 学生信息
     */
    int updateStudentScoreById(StudentDTO studentDTO);

    /**
     * 删除多个学生信息
     *
     * @param ids 学生id
     */
    int deleteStudentByIds(String ids);

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
     * 校验学生工号是否唯一
     *
     * @param studentDTO 学生工号
     * @return 结果
     */
    String checkStuNumUnique(StudentDTO studentDTO);

}
