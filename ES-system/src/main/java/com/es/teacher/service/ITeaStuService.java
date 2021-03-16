package com.es.teacher.service;

import com.es.student.domain.StuUser;

import java.util.List;

/**
 * 教师学生关系 服务层
 *
 * @author qishuaibin
 */
public interface ITeaStuService {
    /**
     * 通过教师id查询已选择学生列表
     *
     * @param teaId 教师ID
     * @return 学生信息列表
     */
    public List<StuUser> selectStuUserListById(Long teaId);
}
