package com.es.teacher.domain;

import com.es.common.core.domain.BaseEntity;

/**
 * 学生教师关系表 tea_stu_rel
 * @Author qishuaibin
 */
public class TeaStuRel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long teaId;

    private Long stuId;

    public TeaStuRel(Long teaId, Long stuId) {
        this.teaId = teaId;
        this.stuId = stuId;
    }

    public TeaStuRel() {
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

    @Override
    public String toString() {
        return "TeaStuRel{" +
                "teaId=" + teaId +
                ", stuId=" + stuId +
                '}';
    }
}
