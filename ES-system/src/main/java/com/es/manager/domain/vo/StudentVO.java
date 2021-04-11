package com.es.manager.domain.vo;

import com.es.common.annotation.Excel;
import com.es.common.core.domain.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author: fudy
 * @date: 2021/4/10 下午 03:45
 * @Decription: 学生信息表出参
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentVO extends SysUser implements Serializable {

    private static final long serialVersionUID = -1748414653212999827L;

    /**
     * 学生id
     */
    private long stuId;
    /**
     * 学生学号
     */
    @Excel(name = "学生学号")
    private String stuNum;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学生性别
     */
    private String stuSex;
    /**
     * 学生年龄
     */
    private String stuAge;
    /**
     * 学生班级
     */
    @Excel(name = "学生原班级")
    private String stuClass;
    /**
     * 学生电话
     */
    private String stuTel;
    /**
     * 学生微信
     */
    private String stuWx;
    /**
     * 学生qq
     */
    private String stuQq;
    /**
     * 学生邮箱
     */
    private String stuMail;
    /**
     * 学生属于哪一年级
     */
    private String stuPeriod;
    /**
     * 学生特长
     */
    private String stuSpe;
    /**
     * 标识，标记可申请卓越班的同学,0为不可申请，1为未申请状态，2为申请待审核状态，3为申请通过状态，4为申请未通过状态
     */
    private int stuIde;
    /**
     * 申请流程状态，0为未进行面试，1为进行面试未通过，3笔试通过，4为未参加面试，5为参加面试未通过，6面试通过
     */
    private int stuPro;

    /**
     * 机试总成绩
     */
    private int machineScore;

    /**
     * 面试成绩
     */
    private int interviewResult;
    /**
     * 面试成绩状态
     */
    private String irStatus;
    /**
     * 第一题机试成绩
     */
    private int oneMachineScore;
    /**
     * 第一题机试成绩状态
     */
    private String oneMsStatus;
    /**
     * 第二题机试成绩
     */
    private int twoMachineScore;
    /**
     * 第二题机试成绩状态
     */
    private String twoMsStatus;
    /**
     * 第三题机试成绩
     */
    private int threeMachineScore;
    /**
     * 第三题机试成绩状态
     */
    private String threeMsStatus;
    /**
     * 第四题机试成绩
     */
    private int fourMachineScore;
    /**
     * 第四题机试成绩状态
     */
    private String fourMsStatus;
    /**
     * 第五题机试成绩
     */
    private int fiveMachineScore;
    /**
     * 第五题机试成绩状态
     */
    private String fiveMsStatus;
    /**
     * 第六题机试成绩
     */
    private int sixMachineScore;
    /**
     * 第刘题机试成绩状态
     */
    private String sixMsStatus;
    /**
     * 第一学期英语成绩
     */
    @Excel(name = "英语成绩")
    private String englishScore;
    /**
     * 第一学期数学成绩
     */
    @Excel(name = "数学成绩")
    private String mathScore;
    /**
     * 第一学期c语言成绩
     */
    @Excel(name = "c语言成绩")
    private String cScore;

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

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getStuWx() {
        return stuWx;
    }

    public void setStuWx(String stuWx) {
        this.stuWx = stuWx;
    }

    public String getStuQq() {
        return stuQq;
    }

    public void setStuQq(String stuQq) {
        this.stuQq = stuQq;
    }

    public String getStuMail() {
        return stuMail;
    }

    public void setStuMail(String stuMail) {
        this.stuMail = stuMail;
    }

    public String getStuPeriod() {
        return stuPeriod;
    }

    public void setStuPeriod(String stuPeriod) {
        this.stuPeriod = stuPeriod;
    }

    public String getStuSpe() {
        return stuSpe;
    }

    public void setStuSpe(String stuSpe) {
        this.stuSpe = stuSpe;
    }

    public int getStuIde() {
        return stuIde;
    }

    public void setStuIde(int stuIde) {
        this.stuIde = stuIde;
    }

    public int getStuPro() {
        return stuPro;
    }

    public void setStuPro(int stuPro) {
        this.stuPro = stuPro;
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

    public String getIrStatus() {
        return irStatus;
    }

    public void setIrStatus(String irStatus) {
        this.irStatus = irStatus;
    }

    public int getOneMachineScore() {
        return oneMachineScore;
    }

    public void setOneMachineScore(int oneMachineScore) {
        this.oneMachineScore = oneMachineScore;
    }

    public String getOneMsStatus() {
        return oneMsStatus;
    }

    public void setOneMsStatus(String oneMsStatus) {
        this.oneMsStatus = oneMsStatus;
    }

    public int getTwoMachineScore() {
        return twoMachineScore;
    }

    public void setTwoMachineScore(int twoMachineScore) {
        this.twoMachineScore = twoMachineScore;
    }

    public String getTwoMsStatus() {
        return twoMsStatus;
    }

    public void setTwoMsStatus(String twoMsStatus) {
        this.twoMsStatus = twoMsStatus;
    }

    public int getThreeMachineScore() {
        return threeMachineScore;
    }

    public void setThreeMachineScore(int threeMachineScore) {
        this.threeMachineScore = threeMachineScore;
    }

    public String getThreeMsStatus() {
        return threeMsStatus;
    }

    public void setThreeMsStatus(String threeMsStatus) {
        this.threeMsStatus = threeMsStatus;
    }

    public int getFourMachineScore() {
        return fourMachineScore;
    }

    public void setFourMachineScore(int fourMachineScore) {
        this.fourMachineScore = fourMachineScore;
    }

    public String getFourMsStatus() {
        return fourMsStatus;
    }

    public void setFourMsStatus(String fourMsStatus) {
        this.fourMsStatus = fourMsStatus;
    }

    public int getFiveMachineScore() {
        return fiveMachineScore;
    }

    public void setFiveMachineScore(int fiveMachineScore) {
        this.fiveMachineScore = fiveMachineScore;
    }

    public String getFiveMsStatus() {
        return fiveMsStatus;
    }

    public void setFiveMsStatus(String fiveMsStatus) {
        this.fiveMsStatus = fiveMsStatus;
    }

    public int getSixMachineScore() {
        return sixMachineScore;
    }

    public void setSixMachineScore(int sixMachineScore) {
        this.sixMachineScore = sixMachineScore;
    }

    public String getSixMsStatus() {
        return sixMsStatus;
    }

    public void setSixMsStatus(String sixMsStatus) {
        this.sixMsStatus = sixMsStatus;
    }

    public String getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(String englishScore) {
        this.englishScore = englishScore;
    }

    public String getMathScore() {
        return mathScore;
    }

    public void setMathScore(String mathScore) {
        this.mathScore = mathScore;
    }

    public String getcScore() {
        return cScore;
    }

    public void setcScore(String cScore) {
        this.cScore = cScore;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "stuId=" + stuId +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge='" + stuAge + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", stuWx='" + stuWx + '\'' +
                ", stuQq='" + stuQq + '\'' +
                ", stuMail='" + stuMail + '\'' +
                ", stuPeriod='" + stuPeriod + '\'' +
                ", stuSpe='" + stuSpe + '\'' +
                ", stuIde=" + stuIde +
                ", stuPro=" + stuPro +
                ", machineScore=" + machineScore +
                ", interviewResult=" + interviewResult +
                ", irStatus='" + irStatus + '\'' +
                ", oneMachineScore=" + oneMachineScore +
                ", oneMsStatus='" + oneMsStatus + '\'' +
                ", twoMachineScore=" + twoMachineScore +
                ", twoMsStatus='" + twoMsStatus + '\'' +
                ", threeMachineScore=" + threeMachineScore +
                ", threeMsStatus='" + threeMsStatus + '\'' +
                ", fourMachineScore=" + fourMachineScore +
                ", fourMsStatus='" + fourMsStatus + '\'' +
                ", fiveMachineScore=" + fiveMachineScore +
                ", fiveMsStatus='" + fiveMsStatus + '\'' +
                ", sixMachineScore=" + sixMachineScore +
                ", sixMsStatus='" + sixMsStatus + '\'' +
                ", englishScore='" + englishScore + '\'' +
                ", mathScore='" + mathScore + '\'' +
                ", cScore='" + cScore + '\'' +
                '}';
    }
}
