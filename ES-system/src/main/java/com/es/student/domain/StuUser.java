package com.es.student.domain;

import com.es.common.core.domain.BaseEntity;

/**
 * 学生信息表 stu_user
 *
 * @Author qishuaibin
 */
public class StuUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long stuId;

    private String stuNum;

    public StuUser(Long stuId, String stuNum) {
        this.stuId = stuId;
        this.stuNum = stuNum;
    }

    public StuUser() {
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Override
    public String toString() {
        return "StuUser{" +
                "stuId=" + stuId +
                ", stuNum='" + stuNum + '\'' +
                '}';
    }
}
