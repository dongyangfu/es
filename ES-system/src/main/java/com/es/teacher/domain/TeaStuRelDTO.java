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
     * 年级
     */
    @Excel(name = "年级")
    private String stuPeriod;

    /**
     * 实践环节
     */
    @Excel(name = "实践环节")
    private String practiceName;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String stuName;

    /**
     * 学号
     */
    @Excel(name = "学号")
    private String stuNum;

    /**
     * 教师ID
     */
    private Long teaId;

    /**
     * 学生ID
     */
    @Excel(name = "学生ID")
    private Long stuId;

    /**
     * 班级
     */
    @Excel(name = "班级")
    private String stuClass;

    /**
     * 课题名称
     */
    @Excel(name = "课题名称")
    private String stuPracticeName;

    /**
     * 成绩
     */
    @Excel(name = "成绩")
    private String score;

    /**
     * 课题编号
     */
    //@Excel(name = "课题编号")
    private String practiceNumber;

    public TeaStuRelDTO() {
    }

    public TeaStuRelDTO(String stuPeriod, String practiceName, String stuName, String stuNum, Long teaId, Long stuId, String stuClass, String stuPracticeName, String score, String practiceNumber) {
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
                '}';
    }
}
