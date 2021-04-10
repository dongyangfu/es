package com.es.teacher.mapper;

import com.es.manager.domain.vo.TeaCourseVO;
import com.es.system.domain.SysUserRole;
import com.es.teacher.domain.TeaCourse;
import com.es.teacher.domain.TeaUserCourse;

import java.util.List;
import java.util.Map;

/**
 * 教师课程表 数据层
 * @author qishuaibin
 */
public interface TeaCourseMapper {
    /**
     * 通过教师ID查询教师担任课程信息
     * @param teaId 教师ID
     * @return list
     */
    List<TeaCourse> selectTeaCourseById(Long teaId);

    /**
     * 通过教师ID查询教师担任课程所有信息
     * @param teaId 教师ID
     * @return list
     */
    List<TeaCourseVO> selectAllTeaCourseById(Long teaId);

    /**
     * 查询所有课程
     * @return list
     */
    List<Map<String,Object>> selectTeaCourseName();

    /**
     * 保存教师的主要担任课程
     * @param map 教师和课程信息
     * @return int
     */
    int insertTeaCourse(Map<String,Object> map);

    /**
     * 批量新增教师课程信息
     *
     * @param teaCourseList 教师课程信息
     * @return 结果
     */
     int batchTeaCourse(List<TeaUserCourse> teaCourseList);

    /**
     * 修改教师的主要担任课程
     * @param map 教师和课程信息
     * @return int
     */
    int updateTeaCourse(Map<String,Object> map);

    /**
     * 删除教师的主要担任课程
     * @param userId 登录用户
     * @return int
     */
    int deleteTeaCourse(Long userId);

    /**
     * 批量删除教师的主要担任课程
     * @param ids 用户ids
     * @return int
     */
    int deleteCourseByIds(Long [] ids);
}
