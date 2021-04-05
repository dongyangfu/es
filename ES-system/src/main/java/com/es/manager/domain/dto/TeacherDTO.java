package com.es.manager.domain.dto;

import com.es.common.annotation.Excel;
import com.es.common.core.domain.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author: fudy
 * @date: 2021/3/27 下午 12:21
 * @Decription: 教师信息表入参
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO extends SysUser implements Serializable {

    private static final long serialVersionUID = -5104602571101842975L;
    /**
     * 教师职称
     */
    @Excel(name = "教师职称")
    private String teacherProfessName;
    /**
     * 专业特长
     */
    private Long[] courses;
    /**
     * 教师id
     */
    @Excel(name = "教师id")
    private Long teaId;
    /**
     * 1教授2副教授3讲师4助教
     */
    @Excel(name = "教师职称编号")
    private Long teaProfess;
    @Excel(name = "教师工号")
    private String teaJobNumber;

    /**
     * 是否卓越班主任
     */
    private Boolean isCharge;
    /**
     * 是否机试批改教师
     */
    private Boolean isComputer;
    /**
     * 是否面试教师
     */
    private Boolean isInterview;

    public Boolean getCharge() {
        return isCharge;
    }

    public void setCharge(Boolean charge) {
        isCharge = charge;
    }

    public Boolean getComputer() {
        return isComputer;
    }

    public void setComputer(Boolean computer) {
        isComputer = computer;
    }

    public Boolean getInterview() {
        return isInterview;
    }

    public void setInterview(Boolean interview) {
        isInterview = interview;
    }

    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    public Long getTeaProfess() {
        return teaProfess;
    }

    public void setTeaProfess(Long teaProfess) {
        this.teaProfess = teaProfess;
    }

    public String getTeaJobNumber() {
        return teaJobNumber;
    }

    public void setTeaJobNumber(String teaJobNumber) {
        this.teaJobNumber = teaJobNumber;
    }

    public String getTeacherProfessName() {
        return teacherProfessName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long[] getCourses() {
        return courses;
    }

    public void setCourses(Long[] courses) {
        this.courses = courses;
    }

    public void setTeacherProfessName(String teacherProfessName) {
        this.teacherProfessName = teacherProfessName;
    }


}
