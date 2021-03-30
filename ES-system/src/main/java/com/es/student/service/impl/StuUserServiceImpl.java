package com.es.student.service.impl;


import com.es.student.domain.StuUser;
import com.es.student.mapper.StuUserMapper;
import com.es.student.service.IStuUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 学生信息 服务层实现
 */
@Service
public class StuUserServiceImpl implements IStuUserService {

    @Resource
    StuUserMapper stuUserMapper;

    /**
     * 查询学生信息
     *
     * @param stuId 学生ID
     * @return 公告信息
     */
    @Override
    public StuUser selectStuUserById(Long stuId){
        return stuUserMapper.selectStuUserById(stuId);
    }
    /**
     * 提交（修改）学生信息
     *
     * @param stuId 学生ID
     * @return 结果
     */
    @Override
    public int updateStuUser(StuUser stuUser){
        return stuUserMapper.updateStuUser(stuUser);
    }
}
