package com.es.teacher.service.impl;

import com.es.student.domain.StuUser;
import com.es.teacher.domain.TeaStuRelDTO;
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
    public List<TeaStuRelDTO> selectStuUserListById(TeaStuRelDTO teaStuRelDTO) {
        List<TeaStuRelDTO> stuUsers = teaStuMapper.selectStuUserListById(teaStuRelDTO);
        return stuUsers;
    }

    @Override
    public List<Map<String, Object>> selectStuSelectList() {
        List<Map<String, Object>> stuUsers = teaStuMapper.selectStuSelectList();
        return stuUsers;
    }

    @Override
    public Map<String, Object> selectStuByStuId(Long stuId) {
        Map<String, Object> student = teaStuMapper.selectStuByStuId(stuId);
        return student;
    }

    @Override
    public int updateStuScore(StuUser stuUser) {
        return teaStuMapper.updateStuScore(stuUser);
    }

    @Override
    public int updateStuScoreTemp(StuUser stuUser) {
        return teaStuMapper.updateStuScoreTemp(stuUser);
    }

    @Override
    public List<StuUser> selectStuListById(Long teaId) {
        List<StuUser> stuUsers = teaStuMapper.selectStuListById(teaId);
        return stuUsers;
    }

    @Override
    public int updateStatus(Map<String, Object> map) {
        return teaStuMapper.updateStatus(map);
    }

    @Override
    public int selectCountById(Long teaId) {
        return teaStuMapper.selectCountById(teaId);
    }

    @Override
    public int updateRejectAll(Long teaId) {
        return teaStuMapper.updateRejectAll(teaId);
    }
}
