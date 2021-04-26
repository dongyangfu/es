package com.es.teacher.service;

import java.util.Map;

/**
 * 教师信息 服务层
 * @author qishuaibin
 */
public interface ITeaUserService {
    /**
     * 通过教师id查询教师信息
     * @param teaId 教师ID
     * @return map
     */
    Map<String,Object> selectTeaUserById(Long teaId);


}
