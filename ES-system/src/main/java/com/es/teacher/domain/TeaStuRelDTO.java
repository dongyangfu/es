package com.es.teacher.domain;

import com.es.common.annotation.Excel;
import com.es.common.core.domain.BaseEntity;

/**
 * @ClassName TeaStuRelDTO
 * @Description 教师下的学生
 * @Author qishuaibin
 */
public class TeaStuRelDTO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 学生ID
     */
    //@Excel(name = "学生ID")
    private Long stuId;

    /**
     * 学号
     */
    @Excel(name = "学号")
    private String stuNum;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String stuName;

    /**
     * 年级
     */
    @Excel(name = "年级")
    private String stuPeriod;

    /**
     * 班级
     */
    @Excel(name = "班级")
    private String stuClass;

    /**
     * 课题名称
     */
    @Excel(name = "课题名称",width = 25)
    private String stuPracticeName;

    /**
     * 成绩
     */
    @Excel(name = "成绩")
    private String score;

    /**
     * 教师姓名
     */
    @Excel(name = "指导教师")
    private String teaName;

    /**
     * 实践环节
     */
    @Excel(name = "实践环节",width = 20)
    private String practiceName;

    /**
     * 教师ID
     */
    private Long teaId;


    /**
     * 课题编号
     */
    //@Excel(name = "课题编号")
    private String practiceNumber;

    /**
     * 学生可以通过状态
     */
    private String status;

    /**
     * 学生联系方式
     */
    private String stuTel;

    /**
     * 学生实践环节ID
     */
    private String practiceId;


    public TeaStuRelDTO() {
    }

    public TeaStuRelDTO(String stuPeriod, String practiceName, String stuName, String stuNum, Long teaId, Long stuId, String stuClass, String stuPracticeName, String score, String practiceNumber, String status, String stuTel, String practiceId, String teaName) {
        this.stuPeriod = stuPeriod;
        this.practiceName = practiceName;
        this.stuName = stuName;
        this.stuNum = stuNum;
        this.teaId = teaId;
        this.stuId = stuId;
        this.stuClass = stuClass;
        this.stuPracticeName = stuPracticeName;
        this.score = score;
        this.practiceNumber = practiceNumber;
        this.status = status;
        this.stuTel = stuTel;
        this.practiceId = practiceId;
        this.teaName = teaName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId;
    }

    public String getStuPeriod() {
        return stuPeriod;
    }

    public void setStuPeriod(String stuPeriod) {
        this.stuPeriod = stuPeriod;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuPracticeName() {
        return stuPracticeName;
    }

    public void setStuPracticeName(String stuPracticeName) {
        this.stuPracticeName = stuPracticeName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPracticeNumber() {
        return practiceNumber;
    }

    public void setPracticeNumber(String practiceNumber) {
        this.practiceNumber = practiceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    @Override
    public String toString() {
        return "TeaStuRelDTO{" +
                "stuPeriod='" + stuPeriod + '\'' +
                ", practiceName='" + practiceName + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", teaId=" + teaId +
                ", stuId=" + stuId +
                ", stuClass='" + stuClass + '\'' +
                ", stuPracticeName='" + stuPracticeName + '\'' +
                ", score='" + score + '\'' +
                ", practiceNumber='" + practiceNumber + '\'' +
                ", status='" + status + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", practiceId='" + practiceId + '\'' +
                ", teaName='" + teaName + '\'' +
                '}';
    }
}
