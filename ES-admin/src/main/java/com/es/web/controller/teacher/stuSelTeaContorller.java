package com.es.web.controller.teacher;

import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.page.TableDataInfo;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.StringUtils;
import com.es.student.domain.StuUser;
import com.es.teacher.service.ITeaStuService;
import com.es.teacher.service.ITeaUserService;
import com.mysql.cj.xdevapi.Warning;
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
@RequestMapping("/teacher/choice")
public class stuSelTeaContorller extends BaseController {
    private String prefix = "teacher/stuSelTea";
    @Resource
    private ITeaStuService teaStuService;

    @Resource
    private ITeaUserService teaUserService;

    @RequiresPermissions("teacher:choice:view")
    @GetMapping()
    public String stuSelTea(ModelMap mmap) {
        Long userId = ShiroUtils.getUserId();
        Map<String, Object> teaMap = teaUserService.selectTeaUserById(userId);
        int count = teaStuService.selectCountById(userId);
        mmap.put("teaMap", teaMap);
        mmap.put("count", count);
        return prefix + "/stuSelTea";
    }

    @RequiresPermissions("teacher:mystu:list")
    @PostMapping("/stuSelTealist")
    @ResponseBody
    public TableDataInfo listStu() {
        Long userId = ShiroUtils.getUserId();
        startPage();
        List<StuUser> list = teaStuService.selectStuListById(userId);
        return getDataTable(list);
    }

    /**
     * 双选阶段，跳转到编辑页面
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        Map<String, Object> stuMap = teaStuService.selectStuByStuId(stuId);
        Long userId = ShiroUtils.getUserId();
        Map<String, Object> teaMap = teaUserService.selectTeaUserById(userId);
        int count = teaStuService.selectCountById(userId);
        mmap.put("teaMap", teaMap);
        mmap.put("count", count);
        mmap.put("stuMap", stuMap);
        return prefix + "/edit";
    }

    /**
     * 双选阶段，教师通过或者驳回学生的选择
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(String status, Long stuId) {
        Long userId = ShiroUtils.getUserId();
        if (StringUtils.isEmpty(status)) {
            status = "02";
        } else if (StringUtils.equals(status, "on")) {
            status = "01";
        }
        Map<String, Object> map = new HashMap<>(20);
        map.put("stuId", stuId);
        map.put("teaId", userId);
        map.put("status", status);
        int uFlag = teaStuService.updateStatus(map);
        Map<String, Object> teaMap = teaUserService.selectTeaUserById(userId);
        int count = teaStuService.selectCountById(userId);
        int maxStu = Integer.parseInt(teaMap.get("max_stu").toString());
        if (uFlag > 0 && Objects.equals(count, maxStu)) {
            int flag = teaStuService.updateRejectAll(userId);
            if (flag >= 0) {
                return success("您可选择的学生到达最大数，已驳回其余已申请的学生信息！");
            }
            return error("系统错误，请联系管理员！");
        } else if (uFlag > 0 && StringUtils.equals("02", status)) {
            return success("成功驳回学生的申请！");
        } else if (uFlag > 0 && StringUtils.equals("01", status) && count < maxStu){
            return success("双选对接成功！此学生成为‘我的学生’");
        }
            return error("保存失败，请联系管理员！");
    }

    /**
     * 双选阶段，选择已满的教师，自动驳回已经申请的学生请求
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/rejectAll")
    @ResponseBody
    public AjaxResult rejectAll() {
        Long userId = ShiroUtils.getUserId();
        int flag = teaStuService.updateRejectAll(userId);
        if (flag > 0) {
            return success("您可选择的学生到达最大数，已驳回其余已申请的学生信息！");
        }
        return error("系统错误，请联系管理员！");
    }

    /**
     * 点击编辑时的教师可选学生人数的判断
     */
    @PostMapping("/contrastNumber")
    @ResponseBody
    public Boolean contrastNumber() {
        Long userId = ShiroUtils.getUserId();
        Map<String, Object> teaMap = teaUserService.selectTeaUserById(userId);
        int count = teaStuService.selectCountById(userId);
        int maxStu = Integer.parseInt(teaMap.get("max_stu").toString());
        if(Objects.equals(count,maxStu)){
            return false;
        }else {
            return count < maxStu;
        }
    }
}
