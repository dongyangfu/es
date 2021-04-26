package com.es.teacher.service;

import com.es.student.domain.StuUser;
import com.es.teacher.domain.TeaStuRelDTO;

import java.util.List;
import java.util.Map;

/**
 * 教师学生关系 服务层
 *
 * @author qishuaibin
 */
public interface ITeaStuService {
    /**
     * 通过教师id查询已选择学生列表
     * @param teaStuRelDTO 查询参数
     * @return 学生信息列表
     */
    List<TeaStuRelDTO> selectStuUserListById(TeaStuRelDTO teaStuRelDTO);

    /**
     * 查询去年新生，第二学期参与选拔的学生列表（选拔阶段）
     * @return 学生信息以及成绩列表
     */
    List<Map<String,Object>>  selectStuSelectList();

    /**
     * 通过学生ID或者 学生ID和教师ID查询学生成绩信息
     *
     * @param stuId 学生ID
     * @return 学生信息以及成绩信息
     */
    Map<String,Object>  selectStuByStuId(Long stuId);

    /**
     * 保存教师提交的学生成绩（提交状态）
     * @param stuUser 学生信息实体类
     * @return int
     */
    int updateStuScore(StuUser stuUser);

    /**
     * 保存教师提交的学生成绩（暂存状态）
     * @param  stuUser 学生信息实体类
     * @return int
     */
    int updateStuScoreTemp(StuUser stuUser);

    /**
     * 通过教师ID查询教师下的学生列表（实践管理-学生选择老师阶段）
     *
     * @param teaId 教师ID
     * @return 学生信息列表
     */
    List<Map<String,Object>>  selectStuListById(Long teaId);

    /**
     * 更新学生选择老师后的通过状态（实践管理阶段）
     * @param map 通过信息
     * @return int
     */
    int updateStatus(Map<String,Object> map);

    /**
     * 根据教师ID查询当前教师已经选择的学生数量
     * @param teaId 教师ID
     * @return int 学生数量
     */
    int selectCountById(Long teaId);

    /**
     * 驳回已满教师的剩余已申请的学生请求
     * @param teaId 教师ID
     * @return int
     */
    int updateRejectAll(Long teaId);

    /**
     * 更新学生课题的成绩信息（实践管理阶段）
     * @param map 通过信息
     * @return int
     */
    int updateCourseStatus(Map<String,Object> map);

    /**
     * 更新学生课题的课题信息（实践管理阶段）
     * @param map 通过信息
     * @return int
     */
    int auditCourseStatus(Map<String,Object> map);

    /**
     * 根据学生信息与实践环节信息查询实践环节ID
     * @param semester 实践环节的学期信息
     * @return
     */
    Map<String,Object> selectPracticeId(String semester);

    /**
     * 插入学生与实践环节的关系
     * @param map 学生id与实践环节ID
     * @return int
     */
    int insertStuPracticeRel(Map<String,Object> map);

    /**
     * 查询去年新生，通过教师ID查询负责面试的学生列表（选拔阶段）
     * @param map 教师信息
     * @return 学生信息
     */
    List<Map<String,Object>> selectStuSelectListInterview(Map<String,Object> map);

    /**
     * 保存教师提交的学生面试成绩（提交状态）
     * @param map 学生成绩信息
     * @return int
     */
    int updateStuInterviewScore(Map<String,Object> map);

    /**
     * 保存教师提交的学生面试成绩（暂存状态）
     * @param map 学生成绩信息
     * @return int
     */
    int updateStuInterviewScoreTemp(Map<String,Object> map);

    /**
     * 通过学生ID和教师ID查询需要修改面试成绩的学生信息
     * @param map 学生ID与教师ID
     * @return map
     */
    Map<String,Object> selectStuByStuIdAndTeaId(Map<String,Object> map);
}
