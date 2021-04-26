package com.es.system.domain;

import javax.validation.constraints.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.es.common.core.domain.BaseEntity;

/**
 * 通知公告表 sys_notice
 */
public class SysNotice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     */
    private Long noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）
     */
    private String noticeType;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告状态（0正常 1关闭）
     */
    private String status;
    /**
     * 公告对象
     */
    private String teaOrStu;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    @NotBlank(message = "公告标题不能为空")
    @Size(min = 0, max = 50, message = "公告标题不能超过50个字符")
    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getTeaOrStu() {
        return teaOrStu;
    }

    public void setTeaOrStu(String teaOrStu) {
        this.teaOrStu = teaOrStu;
    }

    public SysNotice(Long noticeId, String noticeTitle, String noticeType, String noticeContent, String status, String teaOrStu) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeType = noticeType;
        this.noticeContent = noticeContent;
        this.status = status;
        this.teaOrStu = teaOrStu;
    }

    @Override
    public String toString() {
        return "SysNotice{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeType='" + noticeType + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", status='" + status + '\'' +
                ", teaOrStu='" + teaOrStu + '\'' +
                '}';
    }
}
