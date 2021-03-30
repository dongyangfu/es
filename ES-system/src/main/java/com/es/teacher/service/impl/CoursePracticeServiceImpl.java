package com.es.teacher.service.impl;

import com.es.teacher.mapper.CoursePracticeMapper;
import com.es.teacher.service.ICoursePracticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CoursePracticeServiceImpl
 * @Description 实践环节表 业务层
 * @Author qishuaibin
 */
@Service
public class CoursePracticeServiceImpl implements ICoursePracticeService {
    @Resource
    private CoursePracticeMapper coursePracticeMapper;
    @Override
    public List<Map<String, Object>> selectAllPractice() {
        return coursePracticeMapper.selectAllPractice();
    }
}
