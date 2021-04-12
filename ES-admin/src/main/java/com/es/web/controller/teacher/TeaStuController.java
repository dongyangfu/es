package com.es.web.controller.teacher;

import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.page.TableDataInfo;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.StringUtils;
import com.es.common.utils.poi.ExcelUtil;
import com.es.teacher.domain.TeaStuRelDTO;
import com.es.teacher.service.ICoursePracticeService;
import com.es.teacher.service.ITeaStuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 教师下的学生信息
 *
 * @Author qishuaibin
 */
@Controller
@RequestMapping("/teacher/mystu")
public class TeaStuController extends BaseController {
    private String prefix = "teacher/mystu";

    @Resource
    private ITeaStuService teaStuService;
    
    @Resource
    private ICoursePracticeService coursePracticeService;

    @RequiresPermissions("teacher:mystu:view")
    @GetMapping()
    public String myStu(ModelMap mmap) {
        List<Map<String, Object>> practiceList = coursePracticeService.selectAllPractice();
        mmap.put("practiceList",practiceList);
        return prefix + "/mystu";
    }

    @RequiresPermissions("teacher:mystu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TeaStuRelDTO teaStuRelDTO) {
        Long userId = ShiroUtils.getUserId();
        startPage();
        teaStuRelDTO.setTeaId(userId);
        List<TeaStuRelDTO> list = teaStuService.selectStuUserListById(teaStuRelDTO);
        return getDataTable(list);
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeaStuRelDTO teaStuRelDTO) {
        Long userId = ShiroUtils.getUserId();
        teaStuRelDTO.setTeaId(userId);
        List<TeaStuRelDTO> list = teaStuService.selectStuUserListById(teaStuRelDTO);
        ExcelUtil<TeaStuRelDTO> util = new ExcelUtil<TeaStuRelDTO>(TeaStuRelDTO.class);
        return util.exportExcel(list, "学生实践环节数据");
    }

    /**
     * 实践管理，查询老师要修改的学生信息
     */
    @GetMapping("/edit/{stuId}/{practiceId}")
    public String edit(@PathVariable("stuId") Long stuId,@PathVariable("practiceId") String practiceId, ModelMap mmap) {
        TeaStuRelDTO stu = new TeaStuRelDTO();
        stu.setStuId(stuId);
        stu.setTeaId(ShiroUtils.getUserId());
        stu.setPracticeId(practiceId);
        //通过stuId查询学生信息，用于前端修改页面的展示
        List<TeaStuRelDTO> stuMap = teaStuService.selectStuUserListById(stu);
        mmap.put("stuMap", stuMap);
        return prefix + "/myStuEdit";
    }

    /**
     * 实践管理，查询老师要审核的学生信息
     */
    @GetMapping("/audit/{stuId}/{practiceId}")
    public String audit(@PathVariable("stuId") Long stuId,@PathVariable("practiceId") String practiceId, ModelMap mmap) {
        TeaStuRelDTO stu = new TeaStuRelDTO();
        stu.setStuId(stuId);
        stu.setTeaId(ShiroUtils.getUserId());
        stu.setPracticeId(practiceId);
        //通过stuId查询学生信息，用于前端修改页面的展示
        List<TeaStuRelDTO> stuMap = teaStuService.selectStuUserListById(stu);
        mmap.put("stuMap", stuMap);
        return prefix + "/myStuAudit";
    }

    /**
     * 实践管理，教师提交学生课题成绩信息
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Long stuId,String practiceId,String practiceScore) {
        Long userId = ShiroUtils.getUserId();
        Map<String, Object> map = new HashMap<>(20);
        map.put("practiceId",practiceId);
        map.put("stuId", stuId);
        map.put("score", practiceScore);
        int uFlag = teaStuService.updateCourseStatus(map);
        if (uFlag > 0) {
            return success("提交成绩成功！");
        }
        return error("提交失败，请联系管理员！");
    }

    /**
     * 实践管理，教师提交题目以及审核学生课题
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/audit")
    @ResponseBody
    public AjaxResult auditSave(String status, Long stuId,String practiceId,String stuPracticeName) {
        if (StringUtils.isEmpty(status)) {
            //未通过
            status = "01";
        } else if (StringUtils.equals(status, "on")) {
            status = "00";
        }
        Long userId = ShiroUtils.getUserId();
        Map<String, Object> map = new HashMap<>(20);
        map.put("practiceId",practiceId);
        map.put("stuId", stuId);
        map.put("teaId", userId);
        map.put("status", status);
        map.put("stuPracticeName", stuPracticeName);
        int uFlag = teaStuService.auditCourseStatus(map);
        if (uFlag > 0) {
            if(StringUtils.equals(status, "01")){
                return success("驳回学生题目成功！");
            } else if (StringUtils.equals(status, "00")){
                return success("提交学生题目成功！");
            }
        }
        return error("提交失败，请联系管理员！");
    }
}
