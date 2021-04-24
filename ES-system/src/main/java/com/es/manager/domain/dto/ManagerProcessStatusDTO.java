package com.es.manager.domain.dto;

import com.es.manager.domain.entity.ManagerProcessStatus;

import java.io.Serializable;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:33
 * @Decription:
 **/
public class ManagerProcessStatusDTO extends ManagerProcessStatus implements Serializable {

    private static final long serialVersionUID = 4818426492560841414L;

    /**
     * 当前请求的选拔环节
     * 1.预选拔过程
     * 2.机试成绩汇总
     * 3.认定面试教师
     * 4.组建卓越班级
     * 5.选拔结束。
     */
    private Integer requestProcessNum;
    /**
     * 当前环节请求人数
     */
    private Integer processPersonNum;
    /**
     * 面试教师每组几人
     */
    private Integer interviewGroupPersonNum;
    /**
     * 面试教师总共几组
     */
    private Integer interviewGroupNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRequestProcessNum() {
        return requestProcessNum;
    }

    public void setRequestProcessNum(Integer requestProcessNum) {
        this.requestProcessNum = requestProcessNum;
    }

    public Integer getProcessPersonNum() {
        return processPersonNum;
    }

    public void setProcessPersonNum(Integer processPersonNum) {
        this.processPersonNum = processPersonNum;
    }

    public Integer getInterviewGroupNum() {
        return interviewGroupNum;
    }

    public void setInterviewGroupNum(Integer interviewGroupNum) {
        this.interviewGroupNum = interviewGroupNum;
    }

    public Integer getInterviewGroupPersonNum() {
        return interviewGroupPersonNum;
    }

    public void setInterviewGroupPersonNum(Integer interviewGroupPersonNum) {
        this.interviewGroupPersonNum = interviewGroupPersonNum;
    }
}
