package com.es.teacher.service.impl;

import com.es.teacher.mapper.TeaUserMapper;
import com.es.teacher.service.ITeaUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 教师信息 业务层
 * @Author qishuaibin
 */
@Service
public class TeaUserServiceImpl implements ITeaUserService {
    @Resource
    private TeaUserMapper teaUserMapper;

    @Override
    public Map<String, Object> selectTeaUserById(Long teaId) {
        return teaUserMapper.selectTeaUserById(teaId);
    }
}
