package com.es.teacher.service.impl;

import com.es.student.domain.StuUser;
import com.es.teacher.mapper.TeaStuMapper;
import com.es.teacher.service.ITeaStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教师学生关系 业务层
 * @Author qishuaibin
 */
@Service
public class TeaStuServiceImpl implements ITeaStuService {
    @Resource
    private TeaStuMapper teaStuMapper;

    @Override
    public List<StuUser> selectStuUserListById(Long teaId) {
        List<StuUser> stuUsers = teaStuMapper.selectStuUserListById(teaId);
        return stuUsers;
    }
}
