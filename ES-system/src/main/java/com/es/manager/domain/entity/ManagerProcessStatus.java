package com.es.manager.domain.entity;

import com.es.common.core.domain.BaseEntity;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:30
 * @Decription: 卓越选拔流程控制表
 **/
public class ManagerProcessStatus extends BaseEntity {

    private static final long serialVersionUID = -6104378216481509985L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 选拔状态:1.预选拔过程 2.机试成绩汇总3.认定面试教师4.组建卓越班级5.选拔结束。
     */
    private Integer processStatus;
    /**
     * 学生届数 eg：2017、2018、2020
     */
    private Integer period;
    /**
     * 该届选拔状态：0代表正在选拔，1代表已经失效
     */
    private Integer status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
