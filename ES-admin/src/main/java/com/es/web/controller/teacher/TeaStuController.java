package com.es.web.controller.teacher;

import com.es.common.annotation.Log;
import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.domain.entity.SysUser;
import com.es.common.core.page.TableDataInfo;
import com.es.common.enums.BusinessType;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.poi.ExcelUtil;
import com.es.student.domain.StuUser;
import com.es.teacher.domain.TeaStuRelDTO;
import com.es.teacher.service.ICoursePracticeService;
import com.es.teacher.service.ITeaStuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
}
