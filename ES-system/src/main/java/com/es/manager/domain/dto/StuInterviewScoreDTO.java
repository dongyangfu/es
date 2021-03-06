package com.es.manager.domain.dto;

import com.es.manager.domain.entity.StuInterviewScore;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:34
 * @Decription:
 **/
public class StuInterviewScoreDTO extends StuInterviewScore {
    private static final long serialVersionUID = 4588406124191760559L;

    /**
     * 学生id集合
     */
    Long[] stuIds;

    public Long[] getStuIds() {
        return stuIds;
    }

    public void setStuIds(Long[] stuIds) {
        this.stuIds = stuIds;
    }
}
