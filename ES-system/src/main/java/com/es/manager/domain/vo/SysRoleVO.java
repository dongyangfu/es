package com.es.manager.domain.vo;

import com.es.common.core.domain.entity.SysRole;

/**
 * @author: fudy
 * @date: 2021/4/23 下午 09:48
 * @Decription:
 **/
public class SysRoleVO extends SysRole {

    private static final long serialVersionUID = -6162019516583169165L;

    /**
     * 用户id
     */
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
