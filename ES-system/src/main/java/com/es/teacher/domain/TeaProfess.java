package com.es.teacher.domain;

import com.es.common.core.domain.BaseEntity;

/**
 * 教师职称表 tea_profess
 * @Author qishuaibin
 */
public class TeaProfess extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long professId;

    private String professName;

    private int maxStu;

    private String status;

    public TeaProfess(Long professId, String professName, int maxStu, String status) {
        this.professId = professId;
        this.professName = professName;
        this.maxStu = maxStu;
        this.status = status;
    }

    public TeaProfess() {
    }


    public Long getProfessId() {
        return professId;
    }

    public void setProfessId(Long professId) {
        this.professId = professId;
    }

    public String getProfessName() {
        return professName;
    }

    public void setProfessName(String professName) {
        this.professName = professName;
    }

    public int getMaxStu() {
        return maxStu;
    }

    public void setMaxStu(int maxStu) {
        this.maxStu = maxStu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TeaProfess{" +
                "professId=" + professId +
                ", professName='" + professName + '\'' +
                ", maxStu=" + maxStu +
                ", status='" + status + '\'' +
                '}';
    }
}
