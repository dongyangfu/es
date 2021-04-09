package com.es.manager.domain.vo;

import com.es.teacher.domain.TeaCourse;

/**
 * @author: fudy
 * @date: 2021/4/8 下午 10:22
 * @Decription:
 **/
public class TeaCourseVO extends TeaCourse {

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag = false;

}
