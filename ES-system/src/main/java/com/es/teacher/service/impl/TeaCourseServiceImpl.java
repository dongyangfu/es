package com.es.teacher.service.impl;

import com.es.teacher.domain.TeaCourse;
import com.es.teacher.mapper.TeaCourseMapper;
import com.es.teacher.service.ITeaCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 教师担任课程 业务层
 *
 * @Author qishuaibin
 */
@Service
public class TeaCourseServiceImpl implements ITeaCourseService {
    @Resource
    private TeaCourseMapper teaCourseMapper;

    @Override
    public List<TeaCourse> selectTeaCourseById(Long teaId) {
        return teaCourseMapper.selectTeaCourseById(teaId);
    }

    @Override
    public List<Map<String, Object>> selectTeaCourseName() {
        return teaCourseMapper.selectTeaCourseName();
    }

    @Override
    public int insertTeaCourse(Map<String, Object> map) {
        return teaCourseMapper.insertTeaCourse(map);
    }

    @Override
    public int updateTeaCourse(Map<String, Object> map) {
        return teaCourseMapper.updateTeaCourse(map);
    }

    @Override
    public int deleteTeaCourse(Long userId) {
        return teaCourseMapper.deleteTeaCourse(userId);
    }


}
