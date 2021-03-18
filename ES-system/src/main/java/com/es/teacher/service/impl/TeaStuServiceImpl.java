package com.es.teacher.service.impl;

import com.es.student.domain.StuUser;
import com.es.teacher.mapper.TeaStuMapper;
import com.es.teacher.service.ITeaStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map<String, Object>> selectStuSelectListById(Long teaId) {
        List<Map<String, Object>> stuUsers = teaStuMapper.selectStuSelectListById(teaId);
        return stuUsers;
    }

    @Override
    public Map<String, Object> selectStuByStuId(Long stuId) {
        Map<String, Object> student = teaStuMapper.selectStuByStuId(stuId);
        return student;
    }

    @Override
    public int updateStuScore(Map<String, Object> map) {
        return teaStuMapper.updateStuScore(map);
    }

    @Override
    public int updateStuScoreTemp(Map<String, Object> map) {
        return teaStuMapper.updateStuScoreTemp(map);
    }
}
