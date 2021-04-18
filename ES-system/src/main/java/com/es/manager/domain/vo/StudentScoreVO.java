package com.es.manager.domain.vo;

import com.es.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 05:53
 * @Decription: 学生分数汇总表
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentScoreVO implements Serializable {

    private static final long serialVersionUID = -3015681063322721831L;

    /**
     * 学生id
     */
    @Excel(name = "学生id")
    private long stuId;
    /**
     * 学生学号
     */
    @Excel(name = "学生学号")
    private String stuNum;
    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名")
    private String stuName;
    /**
     * 学生班级
     */
    @Excel(name = "学生原班级")
    private String stuClass;
    /**
     * 学生属于哪一年级
     */
    @Excel(name = "学生届数")
    private String stuPeriod;
    /**
     * 机试总成绩
     */
    @Excel(name = "机试总成绩")
    private int machineScore;
    /**
     * 面试成绩
     */
    @Excel(name = "面试成绩")
    private int interviewResult;
    /**
     * 学生总成绩
     */
    @Excel(name = "学生总成绩")
    private Integer resultScore = 0;
    /**
     * 导师教师工号
     */
    @Excel(name = "导师教师工号")
    private String teaJobNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuPeriod() {
        return stuPeriod;
    }

    public void setStuPeriod(String stuPeriod) {
        this.stuPeriod = stuPeriod;
    }

    public int getMachineScore() {
        return machineScore;
    }

    public void setMachineScore(int machineScore) {
        this.machineScore = machineScore;
    }

    public int getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(int interviewResult) {
        this.interviewResult = interviewResult;
    }

    public Integer getResultScore() {
        return resultScore;
    }

    public void setResultScore(Integer resultScore) {
        this.resultScore = resultScore;
    }

    public String getTeaJobNumber() {
        return teaJobNumber;
    }

    public void setTeaJobNumber(String teaJobNumber) {
        this.teaJobNumber = teaJobNumber;
    }
}
