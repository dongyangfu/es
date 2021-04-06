package com.es.web.controller.manger;

import com.alibaba.fastjson.JSON;
import com.es.common.annotation.Log;
import com.es.common.constant.TeacherProfessTypeEnum;
import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.page.TableDataInfo;
import com.es.common.enums.BusinessType;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.poi.ExcelUtil;
import com.es.framework.shiro.service.SysPasswordService;
import com.es.manager.domain.dto.TeacherDTO;
import com.es.manager.domain.vo.TeacherVO;
import com.es.manager.service.ManagerTeacherService;
import com.es.system.service.ISysRoleService;
import com.es.teacher.domain.TeaUser;
import com.es.teacher.service.ITeaCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: fudy
 * @date: 2021/3/17 下午 11:18
 * @Decription: 教师信息管理
 **/
@Controller
@RequestMapping("/manager/teacher")
public class ManagerTeacherController extends BaseController {

    private final static Logger log = LoggerFactory.getLogger(ManagerTeacherController.class);
    private static final String prefix = "manager/teacher";

    @Resource
    private ManagerTeacherService managerTeacherService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ITeaCourseService iTeaCourseService;

    @Autowired
    private SysPasswordService passwordService;


    @RequiresPermissions("manager:teacher:view")
    @GetMapping()
    public String menu() {
        return prefix + "/user";
    }

    @RequiresPermissions("manager:teacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<TeacherVO> teacherList = managerTeacherService.getTeacherList(new TeacherDTO());
        log.info("ManagerTeacherController#list: {}", JSON.toJSONString(teacherList));
        return getDataTable(teacherList);
    }

    /**
     * 修改学生成绩信息
     */
    @GetMapping("/edit/{teaId}")
    public String edit(@PathVariable("teaId") Long teaId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        TeacherDTO dto = new TeacherDTO();
        dto.setTeaId(teaId);
        List<TeacherVO> teacherList = managerTeacherService.getTeacherList(dto);
        mmap.put("teacherInfo", teacherList.get(0));
        mmap.put("teacherProfess", TeacherProfessTypeEnum.values());
        return prefix + "/edit";
    }

    @Log(title = "教师管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeacherDTO dto) {
        List<TeacherVO> teacherList = managerTeacherService.getTeacherList(dto);
        ExcelUtil<TeacherVO> util = new ExcelUtil<>(TeacherVO.class);
        return util.exportExcel(teacherList, "教师信息数据");
    }

    @Log(title = "教师管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<TeaUser> util = new ExcelUtil<>(TeaUser.class);
        List<TeaUser> userList = util.importExcel(file.getInputStream());
        String message = managerTeacherService.importUser(userList, updateSupport, "operName");
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<TeacherDTO> util = new ExcelUtil<>(TeacherDTO.class);
        return util.importTemplateExcel("教师信息数据");
    }

    /**
     * 修改老师信息
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editTeacher(TeacherDTO teacherDTO) {
        int uFlag = managerTeacherService.updateTeacherById(teacherDTO);
        if (uFlag > 0) {
            return success("修改老师信息成功！");
        }
        return error("修改老师信息失败");
    }

    /**
     * 删除老师信息
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult insertTeacher(TeacherDTO teacherDTO) {
        teacherDTO.setTeaJobNumber(teacherDTO.getTeaJobNumber().replace(",", ""));
        teacherDTO.setSalt(ShiroUtils.randomSalt());
        teacherDTO.setPassword(passwordService.encryptPassword(teacherDTO.getLoginName(), teacherDTO.getPassword(), teacherDTO.getSalt()));
        teacherDTO.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(managerTeacherService.insertTeacher(teacherDTO));
    }

    /**
     * 新增教师配置
     *
     * @return String
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("roles", roleService.selectRoleAll().stream().filter(r -> !r.isAdmin() && !r.getRoleName().contains("机试教师")).collect(Collectors.toList()));
        mmap.put("teacherProfess", TeacherProfessTypeEnum.values());
        mmap.put("courses",iTeaCourseService.selectTeaCourseName());
        return prefix + "/add";
    }

    /**
     * 删除老师信息
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult delTeacherList(String ids) {
        int uFlag = managerTeacherService.deleteTeacherByIds(ids);
        if (uFlag > 0) {
            return success("删除老师信息成功！");
        }
        return error("删除老师信息失败");
    }

}
