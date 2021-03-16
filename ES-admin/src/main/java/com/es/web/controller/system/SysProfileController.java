package com.es.web.controller.system;

import com.es.common.annotation.Log;
import com.es.common.config.ESConfig;
import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.domain.entity.SysUser;
import com.es.common.enums.BusinessType;
import com.es.common.utils.DateUtils;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.StringUtils;
import com.es.common.utils.file.FileUploadUtils;
import com.es.framework.shiro.service.SysPasswordService;
import com.es.system.service.ISysUserService;
import com.es.teacher.domain.TeaCourse;
import com.es.teacher.service.ITeaCourseService;
import com.es.teacher.service.ITeaUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 个人信息 业务处理
 */
@Controller
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);

    private String prefix = "system/user/profile";

    @Resource
    private ISysUserService userService;

    @Resource
    private SysPasswordService passwordService;

    @Resource
    private ITeaUserService teaUserService;

    @Resource
    private ITeaCourseService teaCourseService;
    /**
     * 个人信息
     */
    @GetMapping()
    public String profile(ModelMap mmap) {
        SysUser user = ShiroUtils.getSysUser();
        Long userId = ShiroUtils.getUserId();
        mmap.put("user", user);
        mmap.put("roleGroup", userService.selectUserRoleGroup(user.getUserId()));
        mmap.put("postGroup", userService.selectUserPostGroup(user.getUserId()));
        if (StringUtils.equals(user.getUserType(), "01")) {
            Map<String, Object> teaUser = teaUserService.selectTeaUserById(userId);
            List<TeaCourse> teaCourse = teaCourseService.selectTeaCourseById(userId);
            List<Map<String, Object>> courseName = teaCourseService.selectTeaCourseName();
            mmap.put("teaUser",teaUser);
            mmap.put("teaCourse",teaCourse);
            mmap.put("courseName",courseName);
            return "teacher/profile/profile";
        } else if (StringUtils.equals(user.getUserType(), "02")) {

        }
        return prefix + "/profile";
    }

    @GetMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password) {
        SysUser user = ShiroUtils.getSysUser();
        if (passwordService.matches(user, password)) {
            return true;
        }
        return false;
    }

    @GetMapping("/resetPwd")
    public String resetPwd(ModelMap mmap) {
        SysUser user = ShiroUtils.getSysUser();
        mmap.put("user", userService.selectUserById(user.getUserId()));
        return prefix + "/resetPwd";
    }

    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(String oldPassword, String newPassword) {
        SysUser user = ShiroUtils.getSysUser();
        if (!passwordService.matches(user, oldPassword)) {
            return error("修改密码失败，旧密码错误");
        }
        if (passwordService.matches(user, newPassword)) {
            return error("新密码不能与旧密码相同");
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
        user.setPwdUpdateDate(DateUtils.getNowDate());
        if (userService.resetUserPwd(user) > 0) {
            ShiroUtils.setSysUser(userService.selectUserById(user.getUserId()));
            return success();
        }
        return error("修改密码异常，请联系管理员");
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit")
    public String edit(ModelMap mmap) {
        SysUser user = ShiroUtils.getSysUser();
        mmap.put("user", userService.selectUserById(user.getUserId()));
        return prefix + "/edit";
    }

    /**
     * 修改头像
     */
    @GetMapping("/avatar")
    public String avatar(ModelMap mmap) {
        SysUser user = ShiroUtils.getSysUser();
        mmap.put("user", userService.selectUserById(user.getUserId()));
        return prefix + "/avatar";
    }

    /**
     * 修改用户
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(SysUser user) {
        SysUser currentUser = ShiroUtils.getSysUser();
        currentUser.setUserName(user.getUserName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhonenumber(user.getPhonenumber());
        currentUser.setSex(user.getSex());
        if (userService.updateUserInfo(currentUser) > 0) {
            ShiroUtils.setSysUser(userService.selectUserById(currentUser.getUserId()));
            return success();
        }
        return error();
    }

    /**
     * 保存头像
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateAvatar")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file) {
        SysUser currentUser = ShiroUtils.getSysUser();
        try {
            if (!file.isEmpty()) {
                String avatar = FileUploadUtils.upload(ESConfig.getAvatarPath(), file);
                currentUser.setAvatar(avatar);
                if (userService.updateUserInfo(currentUser) > 0) {
                    ShiroUtils.setSysUser(userService.selectUserById(currentUser.getUserId()));
                    return success();
                }
            }
            return error();
        } catch (Exception e) {
            log.error("修改头像失败！", e);
            return error(e.getMessage());
        }
    }
}
