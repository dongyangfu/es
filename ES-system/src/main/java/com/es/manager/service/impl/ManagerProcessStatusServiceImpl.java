package com.es.manager.service.impl;

import com.es.common.utils.PeriodUtil;
import com.es.manager.domain.dto.ManagerProcessStatusDTO;
import com.es.manager.domain.dto.StuInterviewScoreDTO;
import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.vo.ManagerProcessStatusVO;
import com.es.manager.mapper.ManagerProcessStatusMapper;
import com.es.manager.service.ManagerProcessStatusService;
import com.es.manager.service.ManagerStudentService;
import com.es.manager.service.StuInterviewScoreService;
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

    @Resource
    private StuInterviewScoreService stuInterviewScoreService;

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
        return update + n;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int toThirdProcessInterview(ManagerProcessStatusDTO managerProcessStatusDTO) {
        // 先汇总学生总成绩，做平均值，然后存入学生表机试总成绩中，
        StudentDTO dto = new StudentDTO();
        // -1 代表求和总成绩取平均值
        dto.setMachineScore(-1);
        dto.setStuPeriod(PeriodUtil.getNowPeriod());
        int i = managerStudentService.updateStudent(dto);
        // 拿到前n个学生
        Long[] stuIds = managerStudentService.twoProcessStuIds(managerProcessStatusDTO.getProcessPersonNum());
        // 根据进入面试环节的个数，前n个学生状态为3，笔试通过
        StudentDTO dto2 = new StudentDTO();
        dto2.setStuPeriod(PeriodUtil.getNowPeriod());
        dto2.setStuIds(stuIds);
        dto2.setStuPro(3);
        int j = managerStudentService.updateStudentByIds(dto2);
        // 其他学生状态为2笔试未通过
        dto2.setStuPro(2);
        int m = managerStudentService.updateStudentNotByIds(dto2);
        // 修改卓越选拔流程控制，流程由2-》3。
        managerProcessStatusDTO.setProcessStatus(3);
        int update = managerProcessStatusMapper.update(managerProcessStatusDTO);
        // 初始化面试成绩表，每个学生占用4行，因为有四个面试教师打分。
        Long[] fourTimesStuIds = initFourTimesStuIds(stuIds);
        StuInterviewScoreDTO stuInterviewScoreDTO = new StuInterviewScoreDTO();
        stuInterviewScoreDTO.setStuIds(fourTimesStuIds);
        stuInterviewScoreDTO.setPeriod(managerProcessStatusDTO.getPeriod());
        int n = stuInterviewScoreService.insertByIds(stuInterviewScoreDTO);
        return i + j + m + update + n;
    }

    /**
     * 1,2,3,4,5 -> [1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5]
     *
     * @param stuIds 原始学生ids
     * @return 复制4份学生ids
     */
    private Long[] initFourTimesStuIds(Long[] stuIds) {
        // 这份代码很优美
        Long[] result = new Long[stuIds.length * 4];
        int j = 0;
        for (Long stuId : stuIds) {
            result[j++] = stuId;
            result[j++] = stuId;
            result[j++] = stuId;
            result[j++] = stuId;
        }
        return result;
    }
}
