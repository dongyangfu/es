package com.es.manager.mapper;

import com.es.manager.domain.dto.ManagerProcessStatusDTO;
import com.es.manager.domain.vo.ManagerProcessStatusVO;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:39
 * @Decription: 卓越选拔流程及控制
 **/
public interface ManagerProcessStatusMapper {

    /**
     * 获取选拔流程信息
     *
     * @param managerProcessStatusDTO 入参
     * @return ManagerProcessStatusVO
     */
    ManagerProcessStatusVO getManagerProcessStatus(ManagerProcessStatusDTO managerProcessStatusDTO);

    /**
     * 修改
     *
     * @param managerProcessStatusDTO 入参
     * @return Integer
     */
    int update(ManagerProcessStatusDTO managerProcessStatusDTO);
}
