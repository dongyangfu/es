package com.es.web.controller.student;


import com.es.common.annotation.Log;
import com.es.common.constant.UserConstants;
import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.domain.entity.SysUser;
import com.es.common.enums.BusinessType;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.StringUtils;
import com.es.student.domain.StuNotice;
import com.es.student.domain.StuUser;
import com.es.student.service.IStuUserService;
import javafx.scene.control.Label;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学生 信息操作处理
 */

@Controller
@RequestMapping("/student/apply")
public class StuUserController extends BaseController {
    private String prefix = "student/apply";

    @Autowired
    private IStuUserService iStuUserService;

    @RequiresPermissions("student:apply:view")
    @GetMapping()
    public String apply(ModelMap mmap) {
        Long stuUsrId = ShiroUtils.getUserId();
        StuUser stuUser = iStuUserService.selectStuUserById(stuUsrId);
        mmap.put("stuUser",stuUser);
        return prefix + "/apply";
    }

    /**
     * 完善提交申请
     */
    @RequiresPermissions("student:apply:submit")
    @PostMapping("/submit")
    public String  submit(StuUser stuUser) {
       iStuUserService.updateStuUser(stuUser);
       return "redirect:";
    }


}
