package com.es.teacher.mapper;

import java.util.List;
import java.util.Map;

/**
 * 实践环节表 数据层
 * @author qishuaibin
 */
public interface CoursePracticeMapper {
    /**
     * 查询所有实践环节的名称
     *
     * @return listMap
     */
    List<Map<String, Object>> selectAllPractice();
}
