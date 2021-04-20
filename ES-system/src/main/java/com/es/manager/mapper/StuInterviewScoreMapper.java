package com.es.manager.mapper;

import com.es.manager.domain.dto.StuInterviewScoreDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: fudy
 * @date: 2021/4/20 下午 09:54
 * @Decription: 学生面试成绩表
 **/
public interface StuInterviewScoreMapper {


    /**
     * 根据stuIds插入数据
     *
     * @param stuInterviewScoreDTO 学生ids
     * @return int
     */
    int insertByIds(@Param("dto") StuInterviewScoreDTO stuInterviewScoreDTO, @Param("period") Integer period);
}
