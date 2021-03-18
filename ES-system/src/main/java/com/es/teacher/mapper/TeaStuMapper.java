package com.es.teacher.mapper;

import com.es.student.domain.StuUser;

import java.util.List;
import java.util.Map;

/**
 * 教师学生表 数据层
 * @author qishuaibin
 */
public interface TeaStuMapper {

    /**
     * 通过教师id查询已选择学生列表
     *
     * @param teaId 教师ID
     * @return 学生信息列表
     */
    List<StuUser>  selectStuUserListById(Long teaId);

    /**
     * 通过教师id查询管理员分配的学生列表
     *
     * @param teaId 教师ID
     * @return 学生信息以及成绩列表
     */
    List<Map<String,Object>>  selectStuSelectListById(Long teaId);

    /**
     * 通过学生ID查询学生成绩信息
     *
     * @param stuId 学生ID
     * @return 学生信息以及成绩信息
     */
    Map<String,Object>  selectStuByStuId(Long stuId);

    /**
     * 保存教师提交的学生成绩（提交状态）
     * @param map 学生成绩信息
     * @return int
     */
    int updateStuScore(Map<String,Object> map);

    /**
     * 保存教师提交的学生成绩（暂存状态）
     * @param map 学生成绩信息
     * @return int
     */
    int updateStuScoreTemp(Map<String,Object> map);
}
