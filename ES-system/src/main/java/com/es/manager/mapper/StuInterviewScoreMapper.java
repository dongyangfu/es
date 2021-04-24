package com.es.manager.mapper;

import com.es.manager.domain.dto.StuInterviewScoreDTO;
import com.es.manager.domain.vo.StuInterviewScoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 获取所有学生
     *
     * @param stuInterviewScoreDTO 入参
     * @return StuInterviewScoreVO
     */
    List<StuInterviewScoreVO> getAll(StuInterviewScoreDTO stuInterviewScoreDTO);

    /**
     * 获取所有面试教师
     *
     * @param stuInterviewScoreDTO 入参
     * @return StuInterviewScoreVO
     */
    List<StuInterviewScoreVO> getAllInterviewTea(StuInterviewScoreDTO stuInterviewScoreDTO);

    /**
     * 批量修改面试成绩表
     *
     * @param dto 入参
     * @return int
     */
    int updateList(@Param("dto") List<StuInterviewScoreDTO> dto);
}
