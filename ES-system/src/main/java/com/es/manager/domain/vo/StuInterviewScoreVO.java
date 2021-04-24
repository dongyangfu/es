package com.es.manager.domain.vo;

import com.es.common.annotation.Excel;
import com.es.manager.domain.entity.StuInterviewScore;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:35
 * @Decription:
 **/
public class StuInterviewScoreVO extends StuInterviewScore {
    private static final long serialVersionUID = 7650405987518354252L;

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
}
