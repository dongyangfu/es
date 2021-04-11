package com.es.manager.domain.dto;

import com.es.common.annotation.Excel;
import com.es.common.core.domain.entity.SysDept;
import com.es.common.core.domain.entity.SysRole;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author: fudy
 * @date: 2021/4/10 下午 03:59
 * @Decription:
 **/
public class StudentDTOSuper implements Serializable {

    private static final long serialVersionUID = 3134368297609883949L;

    /**
     * 学生id
     */
    private long stuId;
    /**
     * 学生学号
     */
    @Excel(name = "学生学号")
    private String stuNum;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学生性别
     */
    private String stuSex;
    /**
     * 学生年龄
     */
    private String stuAge;
    /**
     * 学生班级
     */
    @Excel(name = "学生原班级")
    private String stuClass;
    /**
     * 学生电话
     */
    private String stuTel;
    /**
     * 学生微信
     */
    private String stuWx;
    /**
     * 学生qq
     */
    private String stuQq;
    /**
     * 学生邮箱
     */
    private String stuMail;
    /**
     * 学生属于哪一年级
     */
    private String stuPeriod;
    /**
     * 学生特长
     */
    private String stuSpe;
    /**
     * 标识，标记可申请卓越班的同学,0为不可申请，1为未申请状态，2为申请待审核状态，3为申请通过状态，4为申请未通过状态
     */
    private int stuIde;
    /**
     * 申请流程状态，0为未进行面试，1为进行面试未通过，3笔试通过，4为未参加面试，5为参加面试未通过，6面试通过
     */
    private int stuPro;

    /**
     * 机试总成绩
     */
    private int machineScore;

    /**
     * 面试成绩
     */
    private int interviewResult;
    /**
     * 面试成绩状态
     */
    private String irStatus;
    /**
     * 第一题机试成绩
     */
    private int oneMachineScore;
    /**
     * 第一题机试成绩状态
     */
    private String oneMsStatus;
    /**
     * 第二题机试成绩
     */
    private int twoMachineScore;
    /**
     * 第二题机试成绩状态
     */
    private String twoMsStatus;
    /**
     * 第三题机试成绩
     */
    private int threeMachineScore;
    /**
     * 第三题机试成绩状态
     */
    private String threeMsStatus;
    /**
     * 第四题机试成绩
     */
    private int fourMachineScore;
    /**
     * 第四题机试成绩状态
     */
    private String fourMsStatus;
    /**
     * 第五题机试成绩
     */
    private int fiveMachineScore;
    /**
     * 第五题机试成绩状态
     */
    private String fiveMsStatus;
    /**
     * 第六题机试成绩
     */
    private int sixMachineScore;
    /**
     * 第刘题机试成绩状态
     */
    private String sixMsStatus;
    /**
     * 第一学期英语成绩
     */
    @Excel(name = "英语成绩")
    private Integer englishScore = 0;
    /**
     * 第一学期数学成绩
     */
    @Excel(name = "数学成绩")
    private Integer mathScore = 0;
    /**
     * 第一学期c语言成绩
     */
    @Excel(name = "c语言成绩")
    private Integer ccScore = 0;

    private Integer cScore = 0;
    /**
     * 用户ID
     */
    @Excel(name = "用户序号", cellType = Excel.ColumnType.NUMERIC, prompt = "用户编号")
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 部门父ID
     */
    private Long parentId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 登录名称
     */
    @Excel(name = "登录名称")
    private String loginName;

    /**
     * 用户名称
     */
    @Excel(name = "学生姓名")
    private String userName;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 用户邮箱
     */
    @Excel(name = "用户邮箱")
    private String email;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    private String phonenumber;

    /**
     * 用户性别
     */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 最后登录IP
     */
    @Excel(name = "最后登录IP", type = Excel.Type.EXPORT)
    private String loginIp;

    /**
     * 最后登录时间
     */
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    private Date loginDate;

    /**
     * 密码最后更新时间
     */
    private Date pwdUpdateDate;

    /**
     * 部门对象
     */
    private SysDept dept;

    private List<SysRole> roles;

    /**
     * 角色组
     */
    private Long[] roleIds;

    /**
     * 岗位组
     */
    private Long[] postIds;

    @Override
    public String toString() {
        return "StudentDTOSuper{" +
                "stuId=" + stuId +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge='" + stuAge + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", stuWx='" + stuWx + '\'' +
                ", stuQq='" + stuQq + '\'' +
                ", stuMail='" + stuMail + '\'' +
                ", stuPeriod='" + stuPeriod + '\'' +
                ", stuSpe='" + stuSpe + '\'' +
                ", stuIde=" + stuIde +
                ", stuPro=" + stuPro +
                ", machineScore=" + machineScore +
                ", interviewResult=" + interviewResult +
                ", irStatus='" + irStatus + '\'' +
                ", oneMachineScore=" + oneMachineScore +
                ", oneMsStatus='" + oneMsStatus + '\'' +
                ", twoMachineScore=" + twoMachineScore +
                ", twoMsStatus='" + twoMsStatus + '\'' +
                ", threeMachineScore=" + threeMachineScore +
                ", threeMsStatus='" + threeMsStatus + '\'' +
                ", fourMachineScore=" + fourMachineScore +
                ", fourMsStatus='" + fourMsStatus + '\'' +
                ", fiveMachineScore=" + fiveMachineScore +
                ", fiveMsStatus='" + fiveMsStatus + '\'' +
                ", sixMachineScore=" + sixMachineScore +
                ", sixMsStatus='" + sixMsStatus + '\'' +
                ", englishScore=" + englishScore +
                ", mathScore=" + mathScore +
                ", cScore=" + cScore +
                ", userId=" + userId +
                ", deptId=" + deptId +
                ", parentId=" + parentId +
                ", roleId=" + roleId +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                ", pwdUpdateDate=" + pwdUpdateDate +
                ", dept=" + dept +
                ", roles=" + roles +
                ", roleIds=" + Arrays.toString(roleIds) +
                ", postIds=" + Arrays.toString(postIds) +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getStuId() {
        return stuId;
    }

    public Integer getCcScore() {
        return ccScore;
    }

    public void setCcScore(Integer ccScore) {
        this.ccScore = ccScore;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getStuWx() {
        return stuWx;
    }

    public void setStuWx(String stuWx) {
        this.stuWx = stuWx;
    }

    public String getStuQq() {
        return stuQq;
    }

    public void setStuQq(String stuQq) {
        this.stuQq = stuQq;
    }

    public String getStuMail() {
        return stuMail;
    }

    public void setStuMail(String stuMail) {
        this.stuMail = stuMail;
    }

    public String getStuPeriod() {
        return stuPeriod;
    }

    public void setStuPeriod(String stuPeriod) {
        this.stuPeriod = stuPeriod;
    }

    public String getStuSpe() {
        return stuSpe;
    }

    public void setStuSpe(String stuSpe) {
        this.stuSpe = stuSpe;
    }

    public int getStuIde() {
        return stuIde;
    }

    public void setStuIde(int stuIde) {
        this.stuIde = stuIde;
    }

    public int getStuPro() {
        return stuPro;
    }

    public void setStuPro(int stuPro) {
        this.stuPro = stuPro;
    }

    public int getMachineScore() {
        return machineScore;
    }

    public void setMachineScore(int machineScore) {
        this.machineScore = machineScore;
    }

    public int getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(int interviewResult) {
        this.interviewResult = interviewResult;
    }

    public String getIrStatus() {
        return irStatus;
    }

    public void setIrStatus(String irStatus) {
        this.irStatus = irStatus;
    }

    public int getOneMachineScore() {
        return oneMachineScore;
    }

    public void setOneMachineScore(int oneMachineScore) {
        this.oneMachineScore = oneMachineScore;
    }

    public String getOneMsStatus() {
        return oneMsStatus;
    }

    public void setOneMsStatus(String oneMsStatus) {
        this.oneMsStatus = oneMsStatus;
    }

    public int getTwoMachineScore() {
        return twoMachineScore;
    }

    public void setTwoMachineScore(int twoMachineScore) {
        this.twoMachineScore = twoMachineScore;
    }

    public String getTwoMsStatus() {
        return twoMsStatus;
    }

    public void setTwoMsStatus(String twoMsStatus) {
        this.twoMsStatus = twoMsStatus;
    }

    public int getThreeMachineScore() {
        return threeMachineScore;
    }

    public void setThreeMachineScore(int threeMachineScore) {
        this.threeMachineScore = threeMachineScore;
    }

    public String getThreeMsStatus() {
        return threeMsStatus;
    }

    public void setThreeMsStatus(String threeMsStatus) {
        this.threeMsStatus = threeMsStatus;
    }

    public int getFourMachineScore() {
        return fourMachineScore;
    }

    public void setFourMachineScore(int fourMachineScore) {
        this.fourMachineScore = fourMachineScore;
    }

    public String getFourMsStatus() {
        return fourMsStatus;
    }

    public void setFourMsStatus(String fourMsStatus) {
        this.fourMsStatus = fourMsStatus;
    }

    public int getFiveMachineScore() {
        return fiveMachineScore;
    }

    public void setFiveMachineScore(int fiveMachineScore) {
        this.fiveMachineScore = fiveMachineScore;
    }

    public String getFiveMsStatus() {
        return fiveMsStatus;
    }

    public void setFiveMsStatus(String fiveMsStatus) {
        this.fiveMsStatus = fiveMsStatus;
    }

    public int getSixMachineScore() {
        return sixMachineScore;
    }

    public void setSixMachineScore(int sixMachineScore) {
        this.sixMachineScore = sixMachineScore;
    }

    public String getSixMsStatus() {
        return sixMsStatus;
    }

    public void setSixMsStatus(String sixMsStatus) {
        this.sixMsStatus = sixMsStatus;
    }

    public Integer getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Integer englishScore) {
        this.englishScore = englishScore;
    }

    public Integer getMathScore() {
        return mathScore;
    }

    public void setMathScore(Integer mathScore) {
        this.mathScore = mathScore;
    }

    public Integer getcScore() {
        return cScore;
    }

    public void setcScore(Integer cScore) {
        this.cScore = cScore;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getPwdUpdateDate() {
        return pwdUpdateDate;
    }

    public void setPwdUpdateDate(Date pwdUpdateDate) {
        this.pwdUpdateDate = pwdUpdateDate;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds() {
        return postIds;
    }

    public void setPostIds(Long[] postIds) {
        this.postIds = postIds;
    }
}
