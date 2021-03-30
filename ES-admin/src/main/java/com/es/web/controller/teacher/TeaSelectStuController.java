package com.es.web.controller.teacher;

import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.page.TableDataInfo;
import com.es.common.utils.ShiroUtils;
import com.es.student.domain.StuUser;
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
 * 教师管理员分配的提交成绩的学生信息
 *
 * @Author qishuaibin
 */
@Controller
@RequestMapping("/teacher/commit")
public class TeaSelectStuController extends BaseController {
    private String prefix = "teacher/mystu";

    @Resource
    private ITeaStuService teaStuService;

    @RequiresPermissions("teacher:commit:view")
    @GetMapping()
    public String commit() {
        return prefix + "/commit";
    }
    @RequiresPermissions("teacher:commit:view")
    @GetMapping("/interview")
    public String commitInterview() {
        return prefix + "/commitInterview";
    }
    @GetMapping("/two")
    public String commitTwo() {
        return prefix + "/commitTwo";
    }
    @GetMapping("/three")
    public String commitThree() {
        return prefix + "/commitThree";
    }
    @GetMapping("/four")
    public String commitFour() {
        return prefix + "/commitFour";
    }
    @GetMapping("/five")
    public String commitFive() {
        return prefix + "/commitFive";
    }
    @GetMapping("/six")
    public String commitSix() {
        return prefix + "/commitSix";
    }

    @PostMapping("/selectList")
    @ResponseBody
    public TableDataInfo selectList() {
        startPage();
        List<Map<String, Object>> list = teaStuService.selectStuSelectList();
        return getDataTable(list);
    }

    /**
     * 修改学生机试成绩信息
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        mmap.put("stuMap", stuMap);
        return prefix + "/edit";
    }
    /**
     * 修改学生机试成绩信息
     */
    @GetMapping("/editTwo/{stuId}")
    public String editTwo(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        mmap.put("stuMap", stuMap);
        return prefix + "/editTwo";
    }
    /**
     * 修改学生机试成绩信息
     */
    @GetMapping("/editThree/{stuId}")
    public String editThree(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        mmap.put("stuMap", stuMap);
        return prefix + "/editThree";
    }
    /**
     * 修改学生机试成绩信息
     */
    @GetMapping("/editFour/{stuId}")
    public String editFour(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        mmap.put("stuMap", stuMap);
        return prefix + "/editFour";
    }
    /**
     * 修改学生机试成绩信息
     */
    @GetMapping("/editFive/{stuId}")
    public String editFive(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        mmap.put("stuMap", stuMap);
        return prefix + "/editFive";
    }
    /**
     * 修改学生机试成绩信息
     */
    @GetMapping("/editSix/{stuId}")
    public String editSix(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        mmap.put("stuMap", stuMap);
        return prefix + "/editSix";
    }

    /**
     * 修改学生面试成绩信息
     */
    @GetMapping("/editInt/{stuId}")
    public String editInt(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        mmap.put("stuMap", stuMap);
        return prefix + "/editInterview";
    }

    /**
     * 修改学生成绩信息(已提交状态)
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StuUser stuUser) {
        int uFlag = teaStuService.updateStuScore(stuUser);
        if(uFlag>0){
            return success("提交成绩成功！");
        }
        return error("提交成绩失败，请联系管理员！");
    }

    /**
     * 修改学生成绩信息(暂存状态)
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/editTemp")
    @ResponseBody
    public AjaxResult editSaveTemp(StuUser stuUser) {
        int uFlag = teaStuService.updateStuScoreTemp(stuUser);
        if(uFlag>0){
            return success("保存成绩成功！");
        }
        return error("保存成绩失败，请联系管理员！");
    }

}
