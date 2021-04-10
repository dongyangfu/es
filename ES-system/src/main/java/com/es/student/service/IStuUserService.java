package com.es.student.service;


import com.es.student.domain.StuUser;

/**
 * 学生信息 服务层
 */
public interface IStuUserService {

    /**
     * 查询学生信息
     *
     * @param stuId 学生ID
     * @return 公告信息
     */
    public StuUser selectStuUserById(Long stuId);
    /**
     * 提交（修改）学生信息
     *
     * @param stuId 学生ID
     * @return 结果
     */
    public int updateStuUser(StuUser stuUser);
    /**
     * 暂时保存学生信息
     *
     * @param stuId 学生ID
     * @return 结果
     */
    public int updateStuUser1(StuUser stuUser);
}
