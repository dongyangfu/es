package com.es.teacher.domain;

import com.es.common.core.domain.BaseEntity;

/**
 * @author: fudy
 * @date: 2021/4/5 下午 09:05
 * @Decription: 教师课程明细表
 **/

public class TeaUserCourse extends BaseEntity {

    /**
     * 课程id
     */
    private Long courseId;
    /**
     * 教师id
     */
    private Long teaId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }
}
