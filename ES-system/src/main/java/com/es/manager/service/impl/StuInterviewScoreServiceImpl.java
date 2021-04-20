package com.es.manager.service.impl;

import com.es.manager.domain.dto.StuInterviewScoreDTO;
import com.es.manager.mapper.StuInterviewScoreMapper;
import com.es.manager.service.StuInterviewScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: fudy
 * @date: 2021/4/20 下午 10:09
 * @Decription:
 **/
@Service
public class StuInterviewScoreServiceImpl implements StuInterviewScoreService {


    @Resource
    private StuInterviewScoreMapper stuInterviewScoreMapper;

    @Override
    public int insertByIds(StuInterviewScoreDTO stuInterviewScoreDTO) {
        return stuInterviewScoreMapper.insertByIds(stuInterviewScoreDTO,stuInterviewScoreDTO.getPeriod());
    }
}
