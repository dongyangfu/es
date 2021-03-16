package com.es.teacher.service;

import com.es.teacher.domain.TeaCourse;

import java.util.List;
import java.util.Map;

/**
 * 教师担任课程 服务层
 * @author qishuaibin
 */
public interface ITeaCourseService {
    /**
     * 通过教师ID查询教师担任课程信息
     * @param teaId 教师ID
     * @return list
     */
    List<TeaCourse> selectTeaCourseById(Long teaId);

    /**
     * 查询所有课程
     * @return list
     */
    List<Map<String,Object>> selectTeaCourseName();

    /**
     * 保存教师的主要担任课程
     * @param map 教师和课程信息
     * @return int
     */
    int insertTeaCourse(Map<String,Object> map);

    /**
     * 修改教师的主要担任课程
     * @param map 教师和课程信息
     * @return int
     */
    int updateTeaCourse(Map<String,Object> map);

    /**
     * 删除教师的主要担任课程
     * @param userId 登录用户
     * @return int
     */
    int deleteTeaCourse(Long userId);
}
