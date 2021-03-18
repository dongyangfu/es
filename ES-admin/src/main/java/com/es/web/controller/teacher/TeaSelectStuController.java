package com.es.web.controller.teacher;

import com.es.common.constant.UserConstants;
import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.domain.entity.SysUser;
import com.es.common.core.page.TableDataInfo;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.StringUtils;
import com.es.teacher.service.ITeaStuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String menu() {
        return prefix + "/commit";
    }

    @PostMapping("/selectList")
    @ResponseBody
    public TableDataInfo selectList() {
        Long userId = ShiroUtils.getUserId();
        startPage();
        List<Map<String, Object>> list = teaStuService.selectStuSelectListById(userId);
        return getDataTable(list);
    }
    /**
     * 修改学生成绩信息
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        mmap.put("stuMap", stuMap);
        return prefix + "/edit";
    }

    /**
     * 修改学生成绩信息(已提交状态)
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Integer machineScore,Long stuId,Integer interviewResult) {
        Long userId = ShiroUtils.getUserId();
        Map<String, Object> map= new HashMap<>(20);
        map.put("machineScore",machineScore);
        map.put("stuId",stuId);
        map.put("interviewResult",interviewResult);
        map.put("teaId",userId);
        int uFlag = teaStuService.updateStuScore(map);
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
    public AjaxResult editSaveTemp(Integer machineScore,Long stuId,Integer interviewResult) {
        Long userId = ShiroUtils.getUserId();
        Map<String, Object> map= new HashMap<>(20);
        map.put("machineScore",machineScore);
        map.put("stuId",stuId);
        map.put("interviewResult",interviewResult);
        map.put("teaId",userId);
        int uFlag = teaStuService.updateStuScoreTemp(map);
        if(uFlag>0){
            return success("保存成绩成功！");
        }
        return error("保存成绩失败，请联系管理员！");
    }

}
