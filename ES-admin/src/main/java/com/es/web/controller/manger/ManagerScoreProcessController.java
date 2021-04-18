package com.es.web.controller.manger;

import com.alibaba.fastjson.JSON;
import com.es.common.annotation.Log;
import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.page.TableDataInfo;
import com.es.common.enums.BusinessType;
import com.es.common.utils.PeriodUtil;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.poi.ExcelUtil;
import com.es.manager.domain.dto.ManagerProcessStatusDTO;
import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.vo.ManagerProcessStatusVO;
import com.es.manager.domain.vo.StudentScoreVO;
import com.es.manager.domain.vo.StudentVO;
import com.es.manager.service.ManagerProcessStatusService;
import com.es.manager.service.ManagerStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 03:13
 * @Decription: 卓越选拔控制
 **/
@Controller
@RequestMapping("/manager/teacher/set")
public class ManagerScoreProcessController extends BaseController {

    private final static Logger log = LoggerFactory.getLogger(ManagerScoreProcessController.class);
    private static final String prefix = "/manager/teacher/set";

    @Autowired
    private ManagerStudentService managerStudentService;

    @Resource
    private ManagerProcessStatusService managerProcessStatusService;

    @RequiresPermissions("manager:teacher:set")
    @GetMapping()
    public String menu() {
        return prefix + "/studentScore";
    }

    @RequiresPermissions("manager:teacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentDTO studentDTO) {
        startPage();
        List<StudentVO> studentList = managerStudentService.getStudentScoreList(studentDTO);
        log.info("ManagerStudentController#list: {}", JSON.toJSONString(studentList));
        return getDataTable(studentList);
    }

    /**
     * 修改学生成绩信息
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        StudentDTO dto = new StudentDTO();
        dto.setStuId(stuId);
        List<StudentVO> studentList = managerStudentService.getStudentScoreList(dto);
        mmap.put("user", studentList.get(0));
        return prefix + "/edit";
    }

    /**
     * 修改学生信息
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editStudent(StudentDTO studentDTO) {
        studentDTO.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(managerStudentService.updateStudentScoreById(studentDTO));
    }

    @Log(title = "学生分数管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentDTO dto) {
        List<StudentVO> studentList = managerStudentService.getStudentScoreList(dto);
        List<StudentScoreVO> studentScoreList = new ArrayList<>();
        studentList.forEach(x -> {
            StudentScoreVO studentScoreVO = new StudentScoreVO();
            BeanUtils.copyProperties(x, studentScoreVO);
            studentScoreList.add(studentScoreVO);
        });
        ExcelUtil<StudentScoreVO> util = new ExcelUtil<>(StudentScoreVO.class);
        return util.exportExcel(studentScoreList, "学生分数数据");
    }

    /**
     * 预选拔
     */
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/firstProcessStudent")
    public String firstProcessStudent(ModelMap mmap) {
        ManagerProcessStatusDTO dto = new ManagerProcessStatusDTO();
        dto.setPeriod(Integer.parseInt(PeriodUtil.getNowPeriod()));
        ManagerProcessStatusVO vo = managerProcessStatusService.getManagerProcessStatus(dto);
        mmap.put("vo", vo);
        return prefix + "/firstProcessStudent";
    }

    /**
     * 预选拔->机试
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/firstProcessStudent/toTwoProcess")
    @ResponseBody
    public AjaxResult toTwoProcess(ManagerProcessStatusDTO dto1,ModelMap map) {
        return  toAjax(managerProcessStatusService.toTwoProcessComputer(dto1));
    }

}
