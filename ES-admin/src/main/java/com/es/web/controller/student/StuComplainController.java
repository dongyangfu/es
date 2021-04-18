package com.es.web.controller.student;

import com.es.common.annotation.Log;
import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.page.TableDataInfo;
import com.es.common.enums.BusinessType;
import com.es.common.utils.ShiroUtils;
import com.es.student.domain.StuComplain;
import com.es.student.domain.StuNotice;
import com.es.student.domain.StuUser;
import com.es.student.service.IStuComplainService;
import com.es.student.service.IStuNoticeService;
import com.es.student.service.IStuUserService;
import com.es.system.domain.SysNotice;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 申诉 信息操作处理
 */
@Controller
@RequestMapping("/student/complain")
public class StuComplainController extends BaseController {
    private String prefix = "student/complain";

    @Autowired
    private IStuComplainService iStuComplainService;

    @Autowired
    private IStuUserService iStuUserService;

    @Autowired
    private IStuNoticeService noticeService;

    @RequiresPermissions("student:complain:view")
    @GetMapping()
    public String complain(ModelMap mmap) {
        Long stuUsrId = ShiroUtils.getUserId();
        StuUser stuUser = iStuUserService.selectStuUserById(stuUsrId);
        mmap.put("stuUser",stuUser);
        return prefix + "/complain";
    }

    /**
     * 查询申诉列表
     */
    @RequiresPermissions("student:complain:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        Long stuUsrId = ShiroUtils.getUserId();
        List<StuComplain> list = iStuComplainService.selectcomplainList(stuUsrId);
        return getDataTable(list);
    }

    /**
     * 新增申诉
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存申诉
     */
    @RequiresPermissions("student:complain:add")
    @Log(title = "申诉", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StuComplain stuComplain) {
        stuComplain.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(iStuComplainService.insertStuComplain(stuComplain,ShiroUtils.getUserId()));
    }

    @RequiresPermissions("student:complain:detail")
    @GetMapping("/detail/{complainId}")
    public String detail(@PathVariable("complainId") Long complainId, ModelMap mmap) {
        mmap.put("complain", iStuComplainService.selectcomplainById(complainId));
        return prefix + "/detail";
    }





    /**
     * 修改公告
     */
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap) {
        //mmap.put("notice", noticeService.selectNoticeById(noticeId));
        return prefix + "/edit";
    }

    /**
     * 修改保存公告
     */
    @RequiresPermissions("student:notice:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StuNotice notice) {
        notice.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(noticeService.updateNotice(notice));
    }

}
