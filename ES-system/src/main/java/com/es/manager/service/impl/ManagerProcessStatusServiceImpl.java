package com.es.manager.service.impl;

import com.es.common.utils.PeriodUtil;
import com.es.manager.domain.dto.ManagerProcessStatusDTO;
import com.es.manager.domain.dto.StuInterviewScoreDTO;
import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.entity.StuInterviewScore;
import com.es.manager.domain.vo.ManagerProcessStatusVO;
import com.es.manager.domain.vo.StuInterviewScoreVO;
import com.es.manager.domain.vo.SysRoleVO;
import com.es.manager.mapper.ManagerProcessStatusMapper;
import com.es.manager.service.ManagerProcessStatusService;
import com.es.manager.service.ManagerStudentService;
import com.es.manager.service.StuInterviewScoreService;
import com.es.system.service.ISysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Resource
    private ISysRoleService sysRoleService;

    @Override
    public ManagerProcessStatusVO getManagerProcessStatus(ManagerProcessStatusDTO managerProcessStatusDTO) {
        return managerProcessStatusMapper.getManagerProcessStatus(managerProcessStatusDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int toTwoProcessComputer(ManagerProcessStatusDTO managerProcessStatusDTO) {
        // 找到 对应届学生，要求不挂科，总成绩（数学+英语+c语言）总数排序  processPersonNum 拿出stu_id
        Long[] stuIds = managerStudentService.firstProcessStuIds(managerProcessStatusDTO.getProcessPersonNum());
        if (stuIds.length == 0){
            return 0;
        }
        // 根据stu——id 修改stu——ide = 1；
        StudentDTO dto = new StudentDTO();
        dto.setStuIds(stuIds);
        dto.setStuIde(3);
        dto.setStuPeriod(PeriodUtil.getNowPeriod());
        int n = managerStudentService.updateStudentByIds(dto);
        // 其他学生状态为2笔试未通过
        dto.setStuIde(4);
        int m = managerStudentService.updateStudentNotByIds(dto);
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int toFourProcessBuildSuperClass(ManagerProcessStatusDTO managerProcessStatusDTO) {
        managerProcessStatusDTO.setInterviewGroupNum(3);
        managerProcessStatusDTO.setInterviewGroupPersonNum(4);
        managerProcessStatusDTO.setPeriod(Integer.parseInt(PeriodUtil.getNowPeriod()));
        //	根据当前时间筛选出今年的学生，如果是21届，2022年春天才会选拔，
        // 查询教师的权限id,根据权限id查询所有符合的教师
        List<SysRoleVO> userIds = sysRoleService.selectUserIdByRoleName("教师");
        //	先找出面试教师权限的所有教师，然后用set存储list，自动打乱顺序
        if (userIds.size() < managerProcessStatusDTO.getInterviewGroupNum() * managerProcessStatusDTO.getInterviewGroupPersonNum()) {
            throw new RuntimeException("教师人数不够，请先导入教师数据");
        }
        // 用stream流筛选出前12个教师，有可能小于12个
        HashSet<Long> teaIdsResult = userIds.stream().map(SysRoleVO::getUserId).limit(managerProcessStatusDTO.getInterviewGroupNum() * managerProcessStatusDTO.getInterviewGroupPersonNum()).collect(Collectors.toCollection(HashSet::new));
        //	填充到面试成绩表，教师中，将学生分为3组
        StuInterviewScoreDTO stuInterviewScoreDTO = new StuInterviewScoreDTO();
        stuInterviewScoreDTO.setPeriod(Integer.parseInt(PeriodUtil.getNowPeriod()));
        Map<Integer, List<StuInterviewScoreVO>> groupByStuId = stuInterviewScoreService.getAll(stuInterviewScoreDTO).stream().collect(Collectors.groupingBy(StuInterviewScore::getStuId));
        int stuGroupSize = groupByStuId.size() / managerProcessStatusDTO.getInterviewGroupNum();
        int stuGroupNum = stuGroupSize;
        int stuGroupOrder = 0;
        for (Map.Entry<Integer, List<StuInterviewScoreVO>> stuIds : groupByStuId.entrySet()) {
            if (stuGroupNum >= stuGroupSize) {
                // 将该组人数置为1
                stuGroupNum = 1;
                ++stuGroupOrder;
            } else {
                ++stuGroupNum;
            }
            List<StuInterviewScoreVO> stuInterviewScoreVOS = stuIds.getValue();
            // 生成四位教师,每位学生信息占用四行
            List<StuInterviewScoreDTO> teaDTO = new ArrayList<>();
            List<Long> groupTeaIds = teaIdsResult.stream().skip((stuGroupOrder - 1) * managerProcessStatusDTO.getInterviewGroupPersonNum()).limit(managerProcessStatusDTO.getInterviewGroupPersonNum()).collect(Collectors.toList());
            int i = 0;
            int isLeader = 1;
            for (Long aLong : groupTeaIds) {
                StuInterviewScoreDTO dto = new StuInterviewScoreDTO();
                dto.setTeaId(aLong.intValue());
                dto.setGroupLeader(i == 0 ? 1 : 0);
                dto.setTeaGroupOrder(stuGroupOrder);
                dto.setId(stuInterviewScoreVOS.get(i++).getId());
                teaDTO.add(dto);
            }
            stuInterviewScoreService.updateList(teaDTO);
        }
        //	修改卓越选拔流程控制，流程由3-》4。
        managerProcessStatusDTO.setProcessStatus(4);
        return managerProcessStatusMapper.update(managerProcessStatusDTO);
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
