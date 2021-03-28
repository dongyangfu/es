package com.es.student.mapper;


import com.es.student.domain.StuUser;

/**
 * 学生信息 数据层
 */
public interface StuUserMapper {
    /**
     * 查询学生信息
     *
     * @param stuId 学生ID
     * @return 公告信息
     */
    public StuUser selectStuUserById(Long stuId);
    /**
     * 提交申请学生信息
     *
     * @param stuId 学生ID
     * @return 结果
     */
    public int updateStuUser(StuUser stuUser);

}
