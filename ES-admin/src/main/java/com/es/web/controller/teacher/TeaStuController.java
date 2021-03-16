package com.es.web.controller.teacher;

import com.es.common.core.controller.BaseController;
import com.es.common.core.page.TableDataInfo;
import com.es.common.utils.ShiroUtils;
import com.es.student.domain.StuUser;
import com.es.teacher.service.ITeaStuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

    @RequiresPermissions("teacher:mystu:view")
    @GetMapping()
    public String menu() {
        return prefix + "/mystu";
    }

    @RequiresPermissions("teacher:mystu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        Long userId = ShiroUtils.getUserId();
        startPage();
        List<StuUser> list = teaStuService.selectStuUserListById(userId);
        return getDataTable(list);
    }

}
