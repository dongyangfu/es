package com.es.manager.service.impl;

import com.es.manager.domain.dto.ManagerProcessStatusDTO;
import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.vo.ManagerProcessStatusVO;
import com.es.manager.mapper.ManagerProcessStatusMapper;
import com.es.manager.service.ManagerProcessStatusService;
import com.es.manager.service.ManagerStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:51
 * @Decription:
 **/
@Service
public class ManagerProcessStatusServiceImpl implements ManagerProcessStatusService {

    @Resource
    private ManagerProcessStatusMapper managerProcessStatusMapper;

    @Resource
    private ManagerStudentService managerStudentService;

    @Override
    public ManagerProcessStatusVO getManagerProcessStatus(ManagerProcessStatusDTO managerProcessStatusDTO) {
        return managerProcessStatusMapper.getManagerProcessStatus(managerProcessStatusDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int toTwoProcessComputer(ManagerProcessStatusDTO managerProcessStatusDTO) {
        // 找到 对应届学生，要求不挂科，总成绩（数学+英语+c语言）总数排序  processPersonNum 拿出stu_id
        Long[] stuIds = managerStudentService.firstProcessStuIds(managerProcessStatusDTO.getProcessPersonNum());
        // 根据stu——id 修改stu——ide = 1；
        StudentDTO dto = new StudentDTO();
        dto.setStuIds(stuIds);
        dto.setStuIde(1);
        int n = managerStudentService.updateStudentByIds(dto);
        // 修改卓越选拔流程控制，流程由1-》2。
        managerProcessStatusDTO.setProcessStatus(2);
        int update = managerProcessStatusMapper.update(managerProcessStatusDTO);
        return update+n;
    }
}
