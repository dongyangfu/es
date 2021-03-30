package com.es.teacher.service;

import java.util.List;
import java.util.Map;

/**
 * 课程环节表 服务层
 * @author qishuaibin
 */
public interface ICoursePracticeService {

    /**
     * 查询所有实践环节的名称
     * @return listMap
     */
    List<Map<String,Object>> selectAllPractice();
}
