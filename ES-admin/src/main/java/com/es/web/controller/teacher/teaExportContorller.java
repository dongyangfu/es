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
import com.es.teacher.service.ITeaUserService;
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

@Controller
@RequestMapping("/teacher/export")
public class teaExportContorller extends BaseController {
    private String prefix = "teacher/export";

    @Resource
    private ITeaStuService teaStuService;
    @Resource
    private ICoursePracticeService coursePracticeService;

    @GetMapping()
    public String score(ModelMap mmap) {
        List<Map<String, Object>> practiceList = coursePracticeService.selectAllPractice();
        mmap.put("practiceList",practiceList);
        return prefix + "/practiceScore";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TeaStuRelDTO teaStuRelDTO) {
        startPage();
        List<TeaStuRelDTO> list = teaStuService.selectStuUserListById(teaStuRelDTO);
        return getDataTable(list);
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeaStuRelDTO teaStuRelDTO) {
        List<TeaStuRelDTO> list = teaStuService.selectStuUserListById(teaStuRelDTO);
        ExcelUtil<TeaStuRelDTO> util = new ExcelUtil<TeaStuRelDTO>(TeaStuRelDTO.class);
        return util.exportExcel(list, "学生实践环节数据");
    }
}
