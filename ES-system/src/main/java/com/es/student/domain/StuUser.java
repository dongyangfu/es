package com.es.student.domain;

import com.es.common.core.domain.BaseEntity;

/**
 * 学生信息表 stu_user
 *
 * @Author hujunhao
 */
public class StuUser extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private long stuId;//学生id
    private String stuNum;//学生学号
    private String stuName;//学生姓名
    private String stuSex;//学生性别
    private String stuAge;//学生年龄
    private String stuClass;//学生班级
    private String stuTel;//学生电话
    private String stuWx;//学生微信
    private String stuQq;//学生qq
    private String stuMail;//学生邮箱
    private String stuSpe;//学生特长
    private int stuIde;//标识，标记可申请卓越班的同学,0为不可申请，1为未申请状态，2为申请待审核状态，3为申请通过状态，4为申请未通过状态
    private int stuPro;//申请流程状态，0为未进行面试，1为进行面试未通过，3笔试通过，4为未参加面试，5为参加面试未通过，6面试通过
    private String stuMt;//机试成绩
    private String stuInt;//面试成绩

    public StuUser() {
    }

    public StuUser(long stuId, String stuNum, String stuName, String stuSex, String stuAge, String stuClass, String stuTel, String stuWx, String stuQq, String stuMail, String stuSpe, int stuIde, int stuPro, String stuMt, String stuInt) {
        this.stuId = stuId;
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuClass = stuClass;
        this.stuTel = stuTel;
        this.stuWx = stuWx;
        this.stuQq = stuQq;
        this.stuSpe = stuSpe;
        this.stuIde = stuIde;
        this.stuPro = stuPro;
        this.stuMt = stuMt;
        this.stuInt = stuInt;
    }

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

    public String getStuMt() {
        return stuMt;
    }

    public void setStuMt(String stuMt) {
        this.stuMt = stuMt;
    }

    public String getStuInt() {
        return stuInt;
    }

    public void setStuInt(String stuInt) {
        this.stuInt = stuInt;
    }

    @Override
    public String toString() {
        return "StuUser{" +
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
                ", stuSpe='" + stuSpe + '\'' +
                ", stuIde=" + stuIde +
                ", stuPro=" + stuPro +
                ", stuMt='" + stuMt + '\'' +
                ", stuInt='" + stuInt + '\'' +
                '}';
    }
}
