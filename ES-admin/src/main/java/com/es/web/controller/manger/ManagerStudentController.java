package com.es.web.controller.manger;

import com.alibaba.fastjson.JSON;
import com.es.common.annotation.Log;
import com.es.common.core.controller.BaseController;
import com.es.common.core.domain.AjaxResult;
import com.es.common.core.domain.entity.SysRole;
import com.es.common.core.domain.entity.SysUser;
import com.es.common.core.page.TableDataInfo;
import com.es.common.enums.BusinessType;
import com.es.common.utils.PeriodUtil;
import com.es.common.utils.ShiroUtils;
import com.es.common.utils.poi.ExcelUtil;
import com.es.framework.shiro.service.SysPasswordService;
import com.es.manager.domain.dto.StudentDTO;
import com.es.manager.domain.dto.StudentDTOSuper;
import com.es.manager.domain.vo.StudentVO;
import com.es.manager.service.ManagerStudentService;
import com.es.system.service.ISysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: fudy
 * @date: 2021/4/10 下午 03:48
 * @Decription: 学生信息管理
 **/
@Controller
@RequestMapping("/manager/student")
public class ManagerStudentController extends BaseController {

    private final static Logger log = LoggerFactory.getLogger(ManagerStudentController.class);
    private static final String prefix = "manager/student";

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ManagerStudentService managerStudentService;

    @Autowired
    private SysPasswordService passwordService;

//    @RequiresPermissions("manager:student:view")
    @GetMapping()
    public String menu() {
        return prefix + "/user";
    }

//    @RequiresPermissions("manager:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentDTO studentDTO) {
        startPage();
        List<StudentVO> StudentList = managerStudentService.getStudentList(studentDTO);
        log.info("ManagerStudentController#list: {}", JSON.toJSONString(StudentList));
        return getDataTable(StudentList);
    }

    @PostMapping("/list/{opt}")
    @ResponseBody
    public TableDataInfo list(@PathVariable String opt) {
        startPage();
        StudentDTO dto = new StudentDTO();
        if ("apply".equals(opt)){
            // 申请进入卓越班
            dto.setStuIde(-2);
        }else if ("approve".equals(opt)){
            // 申请成功学生
            dto.setStuIde(-3);
        }else if ("computer".equals(opt)){
            // 机试通过人数
            dto.setStuPro(3);
        }else if ("superClass".equals(opt)){
            // 面试通过人数
            dto.setStuPro(7);
        }
        dto.setStuPeriod(PeriodUtil.getNowPeriod());
        List<StudentVO> StudentList = managerStudentService.getStudentList(dto);
        log.info("ManagerStudentController#list: {}", JSON.toJSONString(StudentList));
        return getDataTable(StudentList);
    }

    /**
     * 新增学生配置
     *
     * @return String
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("roles", roleService.selectRoleAll().stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return prefix + "/add";
    }

    /**
     * 增加学生信息
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult insertStudent(StudentDTO studentDTO) {
        studentDTO.setStuNum(studentDTO.getStuNum().replace(",", ""));
        studentDTO.setSalt(ShiroUtils.randomSalt());
        studentDTO.setPassword(passwordService.encryptPassword(studentDTO.getLoginName(), studentDTO.getPassword(), studentDTO.getSalt()));
        studentDTO.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(managerStudentService.insertStudent(studentDTO));
    }

    /**
     * 修改学生成绩信息
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        //通过stuId查询学生信息，用于前端修改页面的展示
        StudentDTO dto = new StudentDTO();
        dto.setStuId(userId);
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        List<StudentVO> studentList = managerStudentService.getStudentList(dto);
        mmap.put("user", studentList.get(0));
        mmap.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return prefix + "/edit";
    }

    /**
     * 修改学生信息
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editStudent(StudentDTO studentDTO) {
        studentDTO.setStuId(studentDTO.getUserId());
        studentDTO.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(managerStudentService.updateStudentById(studentDTO));
    }

    /**
     * 删除学生信息
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult delStudentList(String ids) {
        return toAjax(managerStudentService.deleteStudentByIds(ids));
    }


    @Log(title = "学生管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentDTO dto) {
        List<StudentVO> StudentList = managerStudentService.getStudentList(dto);
        ExcelUtil<StudentVO> util = new ExcelUtil<>(StudentVO.class);
        return util.exportExcel(StudentList, "学生信息数据");
    }

    @Log(title = "学生管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<StudentDTOSuper> util = new ExcelUtil<>(StudentDTOSuper.class);
        List<StudentDTOSuper> userList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = managerStudentService.importUser(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<StudentDTOSuper> util = new ExcelUtil<>(StudentDTOSuper.class);
        return util.importTemplateExcel("学生信息数据");
    }

    /**
     * 校验学生学号
     */
    @PostMapping("/checkStuNumUnique")
    @ResponseBody
    public String checkLoginNameUnique(StudentDTO studentDTO) {
        return managerStudentService.checkStuNumUnique(studentDTO);
    }


}
