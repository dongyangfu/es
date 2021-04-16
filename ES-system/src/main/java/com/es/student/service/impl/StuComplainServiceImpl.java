package com.es.student.service.impl;

import com.es.student.domain.StuComplain;
import com.es.student.mapper.StuComplainMapper;
import com.es.student.service.IStuComplainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StuComplainServiceImpl implements IStuComplainService {
    @Resource
    StuComplainMapper stuComplainMapper;

    @Override
    public StuComplain selectcomplainById(Long complainId) {
        return stuComplainMapper.selectcomplainById(complainId);
    }

    @Override
    public List<StuComplain> selectcomplainList(long stuId) {
        /*long[] longs = stuComplainMapper.selectIds(stuId);
        List<StuComplain> comList = new ArrayList<>();
        for (int i=0;i<longs.length;i++) {
            comList.add(stuComplainMapper.selectcomplainById(longs[i]));
        }*/
        return stuComplainMapper.selectStuComplainList(stuId);
    }

    @Override
    public int insertStuComplain(StuComplain stuComplain,long stuId) {
        int n = stuComplainMapper.insertStuComplain(stuComplain);
        long l = stuComplainMapper.selectIdBycomplainTitle(stuComplain.getComplainTitle());
        stuComplainMapper.insertStuCom(stuId,l);
        return (int)l;
    }

    @Override
    public int updateStuComplain(StuComplain stuComplain) {
        return stuComplainMapper.updateStuComplain(stuComplain);
    }

    @Override
    public int deleteStuComplainByIds(String ids) {
        return 0;
    }
}
