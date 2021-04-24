package com.es.manager.domain.entity;

import com.es.common.core.domain.BaseEntity;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:31
 * @Decription: 学生面试成绩表
 **/
public class StuInterviewScore extends BaseEntity {

    private static final long serialVersionUID = 8072583716127633444L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 学生id
     */
    private Integer stuId;
    /**
     * 教师id
     */
    private Integer teaId;
    /**
     * 学生届数 eg：2017、2018、2020
     */
    private Integer period;
    /**
     * 面试分数
     */
    private Integer score;
    /**
     * 教师面试组数，有第一组，第二组，第三组
     */
    private Integer teaGroupOrder;
    /**
     * 该教师是否是组长
     */
    private Integer groupLeader;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
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
