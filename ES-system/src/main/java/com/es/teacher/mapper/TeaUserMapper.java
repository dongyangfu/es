package com.es.teacher.mapper;

import java.util.Map;

/**
 * 教师信息表 数据层
 * @author qishuaibin
 */
public interface TeaUserMapper {
    /**
     * 通过教师id查询教师信息
     * @param teaId 教师ID
     * @return map
     */
    Map<String,Object> selectTeaUserById(Long teaId);


}
