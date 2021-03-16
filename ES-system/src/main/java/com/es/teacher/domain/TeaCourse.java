package com.es.teacher.domain;

import com.es.common.core.domain.BaseEntity;

/**
 * 教师课程表 tea_course
 *
 * @Author qishuaibin
 */
public class TeaCourse extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long courseId;

    private String courseName;

    private String courseType;

    private String status;

    public TeaCourse(Long courseId, String courseName, String courseType, String status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.status = status;
    }

    public TeaCourse() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TeaCourse{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
