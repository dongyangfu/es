package com.es.manager.domain.vo;

import com.es.common.annotation.Excel;
import com.es.common.core.domain.entity.SysUser;
import com.es.teacher.domain.TeaCourse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author: fudy
 * @date: 2021/3/27 下午 12:21
 * @Decription: 教师信息表出参
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherVO extends SysUser implements Serializable {
    private static final long serialVersionUID = -7677572731658612922L;

    /**
     * 教师职称
     */
    @Excel(name = "教师职称")
    private String teacherProfessName;
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
    @Excel(name = "教师状态", readConverterExp = "0=启用,1=禁用,2=未知")
    private String status;
    /**
     * 是否卓越班主任
     */
    @Excel(name = "是否卓越班主任", readConverterExp = "0=否,1=是")
    private Integer isCharge = 0;
    /**
     * 是否机试批改教师
     */
    @Excel(name = "是否机试批改教师", readConverterExp = "0=否,1=是")
    private Integer isComputer=0;
    /**
     * 是否面试教师
     */
    @Excel(name = "是否面试教师", readConverterExp = "0=否,1=是")
    private Integer isInterview=0;

    private List<TeaCourse> courses;

    public List<TeaCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<TeaCourse> courses) {
        this.courses = courses;
    }

    public Integer getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Integer isCharge) {
        this.isCharge = isCharge;
    }

    public Integer getIsComputer() {
        return isComputer;
    }

    public void setIsComputer(Integer isComputer) {
        this.isComputer = isComputer;
    }

    public Integer getIsInterview() {
        return isInterview;
    }

    public void setIsInterview(Integer isInterview) {
        this.isInterview = isInterview;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTeacherProfessName() {
        return teacherProfessName;
    }

    public void setTeacherProfessName(String teacherProfessName) {
        this.teacherProfessName = teacherProfessName;
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

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}
