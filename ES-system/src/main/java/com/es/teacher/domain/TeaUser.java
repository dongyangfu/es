package com.es.teacher.domain;

import com.es.common.annotation.Excel;
import com.es.common.core.domain.BaseEntity;

/**
 * 教师信息表 tea_user
 *
 * @Author qishuaibin
 */
public class TeaUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TeaUser(Long teaId, Long teaProfess, String teaJobNumber, String status) {
        this.teaId = teaId;
        this.teaProfess = teaProfess;
        this.teaJobNumber = teaJobNumber;
        this.status = status;
    }

    public TeaUser() {
    }

    @Override
    public String toString() {
        return "TeaUser{" +
                "teaId=" + teaId +
                ", teaProfess=" + teaProfess +
                ", teaJobNumber='" + teaJobNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
