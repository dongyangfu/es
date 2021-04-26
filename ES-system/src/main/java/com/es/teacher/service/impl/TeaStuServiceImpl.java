package com.es.teacher.service.impl;

import com.es.common.utils.DateUtils;
import com.es.common.utils.StringUtils;
import com.es.student.domain.StuUser;
import com.es.teacher.domain.TeaStuRelDTO;
import com.es.teacher.mapper.TeaStuMapper;
import com.es.teacher.service.ITeaStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 教师学生关系 业务层
 * @Author qishuaibin
 */
@Service
public class TeaStuServiceImpl implements ITeaStuService {
    @Resource
    private TeaStuMapper teaStuMapper;

    @Override
    public List<TeaStuRelDTO> selectStuUserListById(TeaStuRelDTO teaStuRelDTO) {
        List<TeaStuRelDTO> stuUsers = teaStuMapper.selectStuUserListById(teaStuRelDTO);
        int year = Integer.parseInt(DateUtils.dateYear());
        int month = Integer.parseInt(DateUtils.dateMonth());
        List<TeaStuRelDTO> stuList = new ArrayList<>();
        for (TeaStuRelDTO teaStu: stuUsers) {
            int sem = (year - 1 - Integer.parseInt(teaStu.getStuPeriod())) * 2 + (month - 7 < 0 ? 1 : 2) + 1;
            String semester = teaStu.getSemester();
            String semes = null;
            if( 1<month && month<7 || 7<=month && month<10 ){
                semes = sem+"初";
            } else if (5<month && month<8 || 11<=month && month<=12){
                semes = sem+"末";
            }
            if(Objects.equals(semes,semester)){
                stuList.add(teaStu);
            }
        }
        return stuList;
    }

    @Override
    public List<Map<String, Object>> selectStuSelectList() {
        List<Map<String, Object>> stuUsers = teaStuMapper.selectStuSelectList();
        return stuUsers;
    }

    @Override
    public Map<String, Object> selectStuByStuId(Long stuId) {
        return teaStuMapper.selectStuByStuId(stuId);
    }

    @Override
    public int updateStuScore(StuUser stuUser) {
        return teaStuMapper.updateStuScore(stuUser);
    }

    @Override
    public int updateStuScoreTemp(StuUser stuUser) {
        return teaStuMapper.updateStuScoreTemp(stuUser);
    }

    @Override
    public List<Map<String,Object>> selectStuListById(Long teaId) {
        List<Map<String,Object>> stuUsers = teaStuMapper.selectStuListById(teaId);
        return stuUsers;
    }

    @Override
    public int updateStatus(Map<String, Object> map) {
        return teaStuMapper.updateStatus(map);
    }

    @Override
    public int selectCountById(Long teaId) {
        return teaStuMapper.selectCountById(teaId);
    }

    @Override
    public int updateRejectAll(Long teaId) {
        return teaStuMapper.updateRejectAll(teaId);
    }

    @Override
    public int updateCourseStatus(Map<String, Object> map) {
        return teaStuMapper.updateCourseStatus(map);
    }

    @Override
    public int auditCourseStatus(Map<String, Object> map) {
        return teaStuMapper.auditCourseStatus(map);
    }

    @Override
    public Map<String, Object> selectPracticeId(String semester) {
        return teaStuMapper.selectPracticeId(semester);
    }

    @Override
    public int insertStuPracticeRel(Map<String, Object> map) {
        return teaStuMapper.insertStuPracticeRel(map);
    }

    @Override
    public List<Map<String, Object>> selectStuSelectListInterview(Map<String, Object> map) {
        return teaStuMapper.selectStuSelectListInterview(map);
    }

    @Override
    public int updateStuInterviewScore(Map<String, Object> map) {
        return teaStuMapper.updateStuInterviewScore(map);
    }

    @Override
    public int updateStuInterviewScoreTemp(Map<String, Object> map) {
        return teaStuMapper.updateStuInterviewScoreTemp(map);
    }

    @Override
    public Map<String, Object> selectStuByStuIdAndTeaId(Map<String, Object> map) {
        return teaStuMapper.selectStuByStuIdAndTeaId(map);
    }

}
