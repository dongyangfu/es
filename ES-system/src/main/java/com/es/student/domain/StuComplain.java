package com.es.student.domain;

import com.es.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 申诉表 stu_complain
 */
public class StuComplain extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 申诉ID
     */
    private Long complainId;

    /**
     * 申诉标题
     */
    private String complainTitle;

    /**
     * 申诉类型
     */
    private String complainType;

    /**
     * 申诉内容
     */
    private String complainContent;

    /**
     * 反馈内容
     */
    private String feedbackContent;

    public StuComplain(Long complainId, String complainTitle, String complainType, String complainContent, String feedbackContent, String creatBy, String status, int satisfaction) {
        this.complainId = complainId;
        this.complainTitle = complainTitle;
        this.complainType = complainType;
        this.complainContent = complainContent;
        this.feedbackContent = feedbackContent;
        this.creatBy = creatBy;
        this.status = status;
        Satisfaction = satisfaction;
    }


    /**
     * 创建人
     */
    private String creatBy;

    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }

    public StuComplain() {
    }

    /**
     * 申诉状态
     */
    private String status;

    /**
     * 满意度
     */
    private int Satisfaction;//1为满意，2为不满意




    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getComplainId() {
        return complainId;
    }

    public void setComplainId(Long complainId) {
        this.complainId = complainId;
    }

    @NotBlank(message = "申诉标题不能为空")
    @Size(min = 0, max = 50, message = "申诉标题不能超过50个字符")
    public String getComplainTitle() {
        return complainTitle;
    }

    public void setComplainTitle(String complainTitle) {
        this.complainTitle = complainTitle;
    }

    public String getComplainType() {
        return complainType;
    }

    public void setComplainType(String complainType) {
        this.complainType = complainType;
    }

    public String getComplainContent() {
        return complainContent;
    }

    public void setComplainContent(String complainContent) {
        this.complainContent = complainContent;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSatisfaction() {
        return Satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        Satisfaction = satisfaction;
    }

    @Override
    public String toString() {
        return "StuComplain{" +
                "complainId=" + complainId +
                ", complainTitle='" + complainTitle + '\'' +
                ", complainType='" + complainType + '\'' +
                ", complainContent='" + complainContent + '\'' +
                ", feedbackContent='" + feedbackContent + '\'' +
                ", creatBy='" + creatBy + '\'' +
                ", status='" + status + '\'' +
                ", Satisfaction=" + Satisfaction +
                '}';
    }
}
