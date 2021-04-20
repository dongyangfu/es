package com.es.manager.service;

import com.es.manager.domain.dto.StuInterviewScoreDTO;

/**
 * @author: fudy
 * @date: 2021/4/20 下午 10:09
 * @Decription: 学生面试成绩
 **/
public interface StuInterviewScoreService {

    /**
     * 根据stuIds插入数据
     *
     * @param stuInterviewScoreDTO 学生ids
     * @return int
     */
    int insertByIds(StuInterviewScoreDTO stuInterviewScoreDTO);
}
