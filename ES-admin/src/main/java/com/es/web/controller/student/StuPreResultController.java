package com.es.web.controller.student;


import com.es.common.core.controller.BaseController;
import com.es.common.utils.ShiroUtils;
import com.es.student.domain.StuUser;
import com.es.student.service.IStuUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 初审结果
 */

@Controller
@RequestMapping("/student/preresult")
public class StuPreResultController extends BaseController {
    private String prefix = "/student/preresult";

    @Autowired
    private IStuUserService iStuUserService;

    @RequiresPermissions("student:preresult:view")
    @GetMapping()
    public String preresult(ModelMap mmap) {
        Long stuUsrId = ShiroUtils.getUserId();
        StuUser stuUser = iStuUserService.selectStuUserById(stuUsrId);
        mmap.put("stuUser",stuUser);
        return prefix + "/preresult";
    }


}
