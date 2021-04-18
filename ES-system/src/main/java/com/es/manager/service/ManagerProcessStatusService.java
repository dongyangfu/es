package com.es.manager.service;

import com.es.manager.domain.dto.ManagerProcessStatusDTO;
import com.es.manager.domain.vo.ManagerProcessStatusVO;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:50
 * @Decription: 卓越选拔流程及控制
 **/
public interface ManagerProcessStatusService {
    /**
     * 获取选拔流程信息
     *
     * @param managerProcessStatusDTO 入参
     * @return ManagerProcessStatusVO
     */
    ManagerProcessStatusVO getManagerProcessStatus(ManagerProcessStatusDTO managerProcessStatusDTO);

    /**
     * 预选拔-》到达面试状态
     *
     * @param managerProcessStatusDTO 入参
     * @return Boolean 操作结果
     */
    int toTwoProcessComputer(ManagerProcessStatusDTO managerProcessStatusDTO);
}
