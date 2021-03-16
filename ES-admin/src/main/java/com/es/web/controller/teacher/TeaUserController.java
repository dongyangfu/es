package com.es.web.controller.teacher;

import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.utils.ShiroUtils;
import com.es.teacher.service.ITeaCourseService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 教师信息
 *
 * @Author qishuaibin
 */
@Controller
@RequestMapping("/teacher/user")
public class TeaUserController extends BaseController {
    @Resource
    private ITeaCourseService teaCourseService;

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/updateCourse")
    @ResponseBody
    public AjaxResult updateCourse(@RequestParam("courseName") String courseName) {
        Map<String, Object> map = new HashMap<>(20);
        int iFlag=0;int uFlag=0;
        String[] course = courseName.trim().split(",");
        Long userId = ShiroUtils.getUserId();
        map.put("userId",userId);
        teaCourseService.deleteTeaCourse(userId);
        for (String c:course){
            map.put("courseId",c);
            iFlag = teaCourseService.insertTeaCourse(map);
        }
        if(iFlag<0){
            return error("保存失败！");
        }else {
            return success();
        }
    }

}
