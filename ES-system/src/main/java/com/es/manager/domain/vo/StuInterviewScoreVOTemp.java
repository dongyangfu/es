package com.es.manager.domain.vo;

import com.es.common.annotation.Excel;

import java.io.Serializable;

/**
 * @author: fudy
 * @date: 2021/4/24 下午 04:47
 * @Decription: 导出面试教师
 **/
public class StuInterviewScoreVOTemp implements Serializable {
    private static final long serialVersionUID = 426302424481752239L;

    /**
     * 教师姓名
     */
    @Excel(name = "教师姓名")
    private String userName;
    /**
     * 教师工号
     */
    @Excel(name = "教师工号")
    private String teaJobNumber;

    /**
     * 教师面试组数，有第一组，第二组，第三组
     */
    @Excel(name = "组数")
    private Integer teaGroupOrder;
    /**
     * 该教师是否是组长
     */
    @Excel(name = "是否是组长",readConverterExp = "0=组员,1=组长")
    private Integer groupLeader;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTeaJobNumber() {
        return teaJobNumber;
    }

    public void setTeaJobNumber(String teaJobNumber) {
        this.teaJobNumber = teaJobNumber;
    }

    public Integer getTeaGroupOrder() {
        return teaGroupOrder;
    }

    public void setTeaGroupOrder(Integer teaGroupOrder) {
        this.teaGroupOrder = teaGroupOrder;
    }

    public Integer getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(Integer groupLeader) {
        this.groupLeader = groupLeader;
    }
}
