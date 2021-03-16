/*
 Navicat Premium Data Transfer

 Source Server         : benji
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : ry

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 16/03/2021 15:17:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu_user
-- ----------------------------
DROP TABLE IF EXISTS `stu_user`;
CREATE TABLE `stu_user`  (
  `stu_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学生主键',
  `stu_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生学号',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_user
-- ----------------------------
INSERT INTO `stu_user` VALUES (1, '201719244444');
INSERT INTO `stu_user` VALUES (2, '2017192442424');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');
INSERT INTO `sys_config` VALUES (4, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '是否开启注册用户功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (5, '用户管理-密码字符范围', 'sys.account.chrtype', '0', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '默认任意字符范围，0任意（密码可以输入任意字符），1数字（密码只能为0-9数字），2英文字母（密码只能为a-z和A-Z字母），3字母和数字（密码必须包含字母，数字）,4字母数字和特殊字符（目前支持的特殊字符包括：~!@#$%^&*()-=_+）');
INSERT INTO `sys_config` VALUES (6, '用户管理-初始密码修改策略', 'sys.account.initPasswordModify', '0', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '0：初始密码修改策略关闭，没有任何提示，1：提醒用户，如果未修改初始密码，则在登录时就会提醒修改密码对话框');
INSERT INTO `sys_config` VALUES (7, '用户管理-账号密码更新周期', 'sys.account.passwordValidateDays', '0', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '密码更新周期（填写数字，数据初始化值为0不限制，若修改必须为大于0小于365的正整数），如果超过这个周期登录系统时，则在登录时就会提醒修改密码对话框');
INSERT INTO `sys_config` VALUES (8, '主框架页-菜单导航显示风格', 'sys.index.menuStyle', 'default', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '菜单导航显示风格（default为左侧导航菜单，topnav为顶部导航菜单）');
INSERT INTO `sys_config` VALUES (9, '主框架页-是否开启页脚', 'sys.index.ignoreFooter', 'true', 'Y', 'admin', '2021-02-15 17:49:14', '', NULL, '是否开启底部页脚显示（true显示，false隐藏）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(0) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(0) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-02-15 17:49:05', '', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(0) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '其他操作');
INSERT INTO `sys_dict_data` VALUES (19, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (20, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (21, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (22, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (23, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (24, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (25, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (26, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (27, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (28, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (29, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2021-02-15 17:49:13', '', NULL, '停用状态');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2021-02-15 17:49:12', '', NULL, '登录状态列表');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2021-02-15 17:49:15', '', NULL, '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2021-02-15 17:49:15', '', NULL, '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2021-02-15 17:49:15', '', NULL, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 440 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES (100, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误1次', '2021-02-15 17:55:04');
INSERT INTO `sys_logininfor` VALUES (101, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-02-15 17:55:21');
INSERT INTO `sys_logininfor` VALUES (102, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误2次', '2021-02-15 17:55:30');
INSERT INTO `sys_logininfor` VALUES (103, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误3次', '2021-02-15 17:56:03');
INSERT INTO `sys_logininfor` VALUES (104, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误4次', '2021-02-15 17:56:16');
INSERT INTO `sys_logininfor` VALUES (105, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误5次', '2021-02-15 17:56:20');
INSERT INTO `sys_logininfor` VALUES (106, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误5次，帐户锁定10分钟', '2021-02-15 17:56:41');
INSERT INTO `sys_logininfor` VALUES (107, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误1次', '2021-02-15 17:58:13');
INSERT INTO `sys_logininfor` VALUES (108, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误2次', '2021-02-15 17:58:23');
INSERT INTO `sys_logininfor` VALUES (109, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-02-15 18:05:58');
INSERT INTO `sys_logininfor` VALUES (110, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误3次', '2021-02-15 18:06:32');
INSERT INTO `sys_logininfor` VALUES (111, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 18:11:22');
INSERT INTO `sys_logininfor` VALUES (112, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 18:30:13');
INSERT INTO `sys_logininfor` VALUES (113, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 19:26:36');
INSERT INTO `sys_logininfor` VALUES (114, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 19:27:11');
INSERT INTO `sys_logininfor` VALUES (115, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 19:27:40');
INSERT INTO `sys_logininfor` VALUES (116, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 19:31:33');
INSERT INTO `sys_logininfor` VALUES (117, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 19:39:32');
INSERT INTO `sys_logininfor` VALUES (118, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 19:41:30');
INSERT INTO `sys_logininfor` VALUES (119, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-02-15 19:46:58');
INSERT INTO `sys_logininfor` VALUES (120, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-15 20:22:34');
INSERT INTO `sys_logininfor` VALUES (121, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-23 17:24:06');
INSERT INTO `sys_logininfor` VALUES (122, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-23 17:25:11');
INSERT INTO `sys_logininfor` VALUES (123, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-23 17:40:22');
INSERT INTO `sys_logininfor` VALUES (124, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-23 17:42:18');
INSERT INTO `sys_logininfor` VALUES (125, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-23 17:43:17');
INSERT INTO `sys_logininfor` VALUES (126, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-24 17:13:44');
INSERT INTO `sys_logininfor` VALUES (127, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-25 09:25:55');
INSERT INTO `sys_logininfor` VALUES (128, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-26 09:37:02');
INSERT INTO `sys_logininfor` VALUES (129, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-27 12:19:31');
INSERT INTO `sys_logininfor` VALUES (130, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-27 12:41:31');
INSERT INTO `sys_logininfor` VALUES (131, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-27 16:54:37');
INSERT INTO `sys_logininfor` VALUES (132, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-02-27 17:24:09');
INSERT INTO `sys_logininfor` VALUES (133, '111', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误1次', '2021-02-27 17:24:17');
INSERT INTO `sys_logininfor` VALUES (134, '111', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '密码输入错误2次', '2021-02-27 17:25:03');
INSERT INTO `sys_logininfor` VALUES (135, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-27 17:25:19');
INSERT INTO `sys_logininfor` VALUES (136, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-02-27 17:26:25');
INSERT INTO `sys_logininfor` VALUES (137, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-27 17:26:31');
INSERT INTO `sys_logininfor` VALUES (138, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 12:38:06');
INSERT INTO `sys_logininfor` VALUES (139, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:19:12');
INSERT INTO `sys_logininfor` VALUES (140, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:22:29');
INSERT INTO `sys_logininfor` VALUES (141, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:24:13');
INSERT INTO `sys_logininfor` VALUES (142, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:29:32');
INSERT INTO `sys_logininfor` VALUES (143, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:38:22');
INSERT INTO `sys_logininfor` VALUES (144, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:40:24');
INSERT INTO `sys_logininfor` VALUES (145, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:41:59');
INSERT INTO `sys_logininfor` VALUES (146, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:44:36');
INSERT INTO `sys_logininfor` VALUES (147, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:47:16');
INSERT INTO `sys_logininfor` VALUES (148, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:48:56');
INSERT INTO `sys_logininfor` VALUES (149, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-02-28 14:53:38');
INSERT INTO `sys_logininfor` VALUES (150, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 09:03:09');
INSERT INTO `sys_logininfor` VALUES (151, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 09:03:42');
INSERT INTO `sys_logininfor` VALUES (152, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 09:19:41');
INSERT INTO `sys_logininfor` VALUES (153, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 09:58:08');
INSERT INTO `sys_logininfor` VALUES (154, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 10:05:55');
INSERT INTO `sys_logininfor` VALUES (155, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 10:09:25');
INSERT INTO `sys_logininfor` VALUES (156, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 10:12:45');
INSERT INTO `sys_logininfor` VALUES (157, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 10:13:03');
INSERT INTO `sys_logininfor` VALUES (158, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 10:13:58');
INSERT INTO `sys_logininfor` VALUES (159, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 10:15:05');
INSERT INTO `sys_logininfor` VALUES (160, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 10:55:20');
INSERT INTO `sys_logininfor` VALUES (161, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 11:08:54');
INSERT INTO `sys_logininfor` VALUES (162, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 11:16:51');
INSERT INTO `sys_logininfor` VALUES (163, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 11:24:08');
INSERT INTO `sys_logininfor` VALUES (164, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-02 11:45:35');
INSERT INTO `sys_logininfor` VALUES (165, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-02 11:45:37');
INSERT INTO `sys_logininfor` VALUES (166, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 11:45:40');
INSERT INTO `sys_logininfor` VALUES (167, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 11:58:30');
INSERT INTO `sys_logininfor` VALUES (168, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 15:32:07');
INSERT INTO `sys_logininfor` VALUES (169, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-02 15:34:32');
INSERT INTO `sys_logininfor` VALUES (170, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-02 15:34:56');
INSERT INTO `sys_logininfor` VALUES (171, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-03-02 15:38:14');
INSERT INTO `sys_logininfor` VALUES (172, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-02 16:52:27');
INSERT INTO `sys_logininfor` VALUES (173, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-03-02 16:53:29');
INSERT INTO `sys_logininfor` VALUES (174, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-03 15:06:24');
INSERT INTO `sys_logininfor` VALUES (175, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-03-03 15:06:36');
INSERT INTO `sys_logininfor` VALUES (176, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-03 15:06:42');
INSERT INTO `sys_logininfor` VALUES (177, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-03 16:15:52');
INSERT INTO `sys_logininfor` VALUES (178, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 09:53:34');
INSERT INTO `sys_logininfor` VALUES (179, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-03-06 09:56:42');
INSERT INTO `sys_logininfor` VALUES (180, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 09:56:47');
INSERT INTO `sys_logininfor` VALUES (181, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 10:08:14');
INSERT INTO `sys_logininfor` VALUES (182, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 10:16:49');
INSERT INTO `sys_logininfor` VALUES (183, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 11:26:13');
INSERT INTO `sys_logininfor` VALUES (184, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 11:28:56');
INSERT INTO `sys_logininfor` VALUES (185, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 11:31:32');
INSERT INTO `sys_logininfor` VALUES (186, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 11:33:47');
INSERT INTO `sys_logininfor` VALUES (187, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 11:35:13');
INSERT INTO `sys_logininfor` VALUES (188, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 15:33:19');
INSERT INTO `sys_logininfor` VALUES (189, 'qs', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '用户不存在/密码错误', '2021-03-06 15:41:08');
INSERT INTO `sys_logininfor` VALUES (190, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 15:41:13');
INSERT INTO `sys_logininfor` VALUES (191, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 15:44:40');
INSERT INTO `sys_logininfor` VALUES (192, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 15:54:21');
INSERT INTO `sys_logininfor` VALUES (193, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 15:56:04');
INSERT INTO `sys_logininfor` VALUES (194, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 15:59:52');
INSERT INTO `sys_logininfor` VALUES (195, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:02:53');
INSERT INTO `sys_logininfor` VALUES (196, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:03:40');
INSERT INTO `sys_logininfor` VALUES (197, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:05:48');
INSERT INTO `sys_logininfor` VALUES (198, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:09:32');
INSERT INTO `sys_logininfor` VALUES (199, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:10:19');
INSERT INTO `sys_logininfor` VALUES (200, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:11:54');
INSERT INTO `sys_logininfor` VALUES (201, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:29:32');
INSERT INTO `sys_logininfor` VALUES (202, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:31:08');
INSERT INTO `sys_logininfor` VALUES (203, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:32:09');
INSERT INTO `sys_logininfor` VALUES (204, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:33:53');
INSERT INTO `sys_logininfor` VALUES (205, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:34:44');
INSERT INTO `sys_logininfor` VALUES (206, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:35:46');
INSERT INTO `sys_logininfor` VALUES (207, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-06 16:43:23');
INSERT INTO `sys_logininfor` VALUES (208, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 16:43:26');
INSERT INTO `sys_logininfor` VALUES (209, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:02:15');
INSERT INTO `sys_logininfor` VALUES (210, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:39:55');
INSERT INTO `sys_logininfor` VALUES (211, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:41:09');
INSERT INTO `sys_logininfor` VALUES (212, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-03-06 17:41:13');
INSERT INTO `sys_logininfor` VALUES (213, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:41:19');
INSERT INTO `sys_logininfor` VALUES (214, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:44:51');
INSERT INTO `sys_logininfor` VALUES (215, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:45:45');
INSERT INTO `sys_logininfor` VALUES (216, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:46:36');
INSERT INTO `sys_logininfor` VALUES (217, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:48:36');
INSERT INTO `sys_logininfor` VALUES (218, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:51:09');
INSERT INTO `sys_logininfor` VALUES (219, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:56:16');
INSERT INTO `sys_logininfor` VALUES (220, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 17:57:36');
INSERT INTO `sys_logininfor` VALUES (221, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 18:00:39');
INSERT INTO `sys_logininfor` VALUES (222, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-06 18:12:11');
INSERT INTO `sys_logininfor` VALUES (223, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-07 14:04:46');
INSERT INTO `sys_logininfor` VALUES (224, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-03-07 14:05:13');
INSERT INTO `sys_logininfor` VALUES (225, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-07 14:05:19');
INSERT INTO `sys_logininfor` VALUES (226, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-03-07 14:05:59');
INSERT INTO `sys_logininfor` VALUES (227, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-07 14:06:18');
INSERT INTO `sys_logininfor` VALUES (228, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 11:15:32');
INSERT INTO `sys_logininfor` VALUES (229, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 11:18:03');
INSERT INTO `sys_logininfor` VALUES (230, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 11:19:02');
INSERT INTO `sys_logininfor` VALUES (231, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 11:24:54');
INSERT INTO `sys_logininfor` VALUES (232, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 11:28:44');
INSERT INTO `sys_logininfor` VALUES (233, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 11:31:21');
INSERT INTO `sys_logininfor` VALUES (234, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 11:32:24');
INSERT INTO `sys_logininfor` VALUES (235, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:03:37');
INSERT INTO `sys_logininfor` VALUES (236, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:06:18');
INSERT INTO `sys_logininfor` VALUES (237, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:07:33');
INSERT INTO `sys_logininfor` VALUES (238, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:08:39');
INSERT INTO `sys_logininfor` VALUES (239, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:10:42');
INSERT INTO `sys_logininfor` VALUES (240, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:12:38');
INSERT INTO `sys_logininfor` VALUES (241, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:14:14');
INSERT INTO `sys_logininfor` VALUES (242, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:16:37');
INSERT INTO `sys_logininfor` VALUES (243, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:17:52');
INSERT INTO `sys_logininfor` VALUES (244, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:56:20');
INSERT INTO `sys_logininfor` VALUES (245, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 14:58:27');
INSERT INTO `sys_logininfor` VALUES (246, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:00:06');
INSERT INTO `sys_logininfor` VALUES (247, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:01:17');
INSERT INTO `sys_logininfor` VALUES (248, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:02:28');
INSERT INTO `sys_logininfor` VALUES (249, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:03:58');
INSERT INTO `sys_logininfor` VALUES (250, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:06:25');
INSERT INTO `sys_logininfor` VALUES (251, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:09:18');
INSERT INTO `sys_logininfor` VALUES (252, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:11:06');
INSERT INTO `sys_logininfor` VALUES (253, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:12:42');
INSERT INTO `sys_logininfor` VALUES (254, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:14:15');
INSERT INTO `sys_logininfor` VALUES (255, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:15:38');
INSERT INTO `sys_logininfor` VALUES (256, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:16:50');
INSERT INTO `sys_logininfor` VALUES (257, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:17:45');
INSERT INTO `sys_logininfor` VALUES (258, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:19:52');
INSERT INTO `sys_logininfor` VALUES (259, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:22:07');
INSERT INTO `sys_logininfor` VALUES (260, 'admin', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '退出成功', '2021-03-08 15:23:00');
INSERT INTO `sys_logininfor` VALUES (261, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:23:05');
INSERT INTO `sys_logininfor` VALUES (262, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:25:08');
INSERT INTO `sys_logininfor` VALUES (263, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:27:43');
INSERT INTO `sys_logininfor` VALUES (264, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:30:54');
INSERT INTO `sys_logininfor` VALUES (265, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:38:23');
INSERT INTO `sys_logininfor` VALUES (266, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:40:18');
INSERT INTO `sys_logininfor` VALUES (267, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:44:45');
INSERT INTO `sys_logininfor` VALUES (268, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:51:56');
INSERT INTO `sys_logininfor` VALUES (269, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:54:58');
INSERT INTO `sys_logininfor` VALUES (270, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:58:32');
INSERT INTO `sys_logininfor` VALUES (271, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 15:59:37');
INSERT INTO `sys_logininfor` VALUES (272, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 16:21:22');
INSERT INTO `sys_logininfor` VALUES (273, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-08 16:24:13');
INSERT INTO `sys_logininfor` VALUES (274, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-08 16:24:18');
INSERT INTO `sys_logininfor` VALUES (275, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 16:24:25');
INSERT INTO `sys_logininfor` VALUES (276, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 16:52:31');
INSERT INTO `sys_logininfor` VALUES (277, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 16:54:10');
INSERT INTO `sys_logininfor` VALUES (278, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 16:56:56');
INSERT INTO `sys_logininfor` VALUES (279, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 16:58:48');
INSERT INTO `sys_logininfor` VALUES (280, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:03:07');
INSERT INTO `sys_logininfor` VALUES (281, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:04:51');
INSERT INTO `sys_logininfor` VALUES (282, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:17:05');
INSERT INTO `sys_logininfor` VALUES (283, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:19:02');
INSERT INTO `sys_logininfor` VALUES (284, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:26:23');
INSERT INTO `sys_logininfor` VALUES (285, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:30:55');
INSERT INTO `sys_logininfor` VALUES (286, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:32:16');
INSERT INTO `sys_logininfor` VALUES (287, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:33:45');
INSERT INTO `sys_logininfor` VALUES (288, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:35:32');
INSERT INTO `sys_logininfor` VALUES (289, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:39:33');
INSERT INTO `sys_logininfor` VALUES (290, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:41:05');
INSERT INTO `sys_logininfor` VALUES (291, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:43:09');
INSERT INTO `sys_logininfor` VALUES (292, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:46:44');
INSERT INTO `sys_logininfor` VALUES (293, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-08 17:59:50');
INSERT INTO `sys_logininfor` VALUES (294, 'qsb', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2021-03-08 18:01:41');
INSERT INTO `sys_logininfor` VALUES (295, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:02:38');
INSERT INTO `sys_logininfor` VALUES (296, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:04:11');
INSERT INTO `sys_logininfor` VALUES (297, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:17:19');
INSERT INTO `sys_logininfor` VALUES (298, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:19:41');
INSERT INTO `sys_logininfor` VALUES (299, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:21:19');
INSERT INTO `sys_logininfor` VALUES (300, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:22:39');
INSERT INTO `sys_logininfor` VALUES (301, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:24:08');
INSERT INTO `sys_logininfor` VALUES (302, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:26:33');
INSERT INTO `sys_logininfor` VALUES (303, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:37:17');
INSERT INTO `sys_logininfor` VALUES (304, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:39:05');
INSERT INTO `sys_logininfor` VALUES (305, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:40:52');
INSERT INTO `sys_logininfor` VALUES (306, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:42:51');
INSERT INTO `sys_logininfor` VALUES (307, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:43:58');
INSERT INTO `sys_logininfor` VALUES (308, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:46:18');
INSERT INTO `sys_logininfor` VALUES (309, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:48:30');
INSERT INTO `sys_logininfor` VALUES (310, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:51:54');
INSERT INTO `sys_logininfor` VALUES (311, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 09:53:16');
INSERT INTO `sys_logininfor` VALUES (312, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:33:59');
INSERT INTO `sys_logininfor` VALUES (313, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:35:09');
INSERT INTO `sys_logininfor` VALUES (314, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:36:49');
INSERT INTO `sys_logininfor` VALUES (315, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:37:55');
INSERT INTO `sys_logininfor` VALUES (316, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-09 14:40:53');
INSERT INTO `sys_logininfor` VALUES (317, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:40:56');
INSERT INTO `sys_logininfor` VALUES (318, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:41:58');
INSERT INTO `sys_logininfor` VALUES (319, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:43:21');
INSERT INTO `sys_logininfor` VALUES (320, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:44:14');
INSERT INTO `sys_logininfor` VALUES (321, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:47:09');
INSERT INTO `sys_logininfor` VALUES (322, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:48:22');
INSERT INTO `sys_logininfor` VALUES (323, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:50:07');
INSERT INTO `sys_logininfor` VALUES (324, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 14:53:18');
INSERT INTO `sys_logininfor` VALUES (325, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-09 15:01:01');
INSERT INTO `sys_logininfor` VALUES (326, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:28:21');
INSERT INTO `sys_logininfor` VALUES (327, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:29:32');
INSERT INTO `sys_logininfor` VALUES (328, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:30:24');
INSERT INTO `sys_logininfor` VALUES (329, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:31:48');
INSERT INTO `sys_logininfor` VALUES (330, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-12 10:32:35');
INSERT INTO `sys_logininfor` VALUES (331, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:32:39');
INSERT INTO `sys_logininfor` VALUES (332, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:33:43');
INSERT INTO `sys_logininfor` VALUES (333, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:34:36');
INSERT INTO `sys_logininfor` VALUES (334, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:35:40');
INSERT INTO `sys_logininfor` VALUES (335, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:36:39');
INSERT INTO `sys_logininfor` VALUES (336, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:40:17');
INSERT INTO `sys_logininfor` VALUES (337, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:41:00');
INSERT INTO `sys_logininfor` VALUES (338, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:42:23');
INSERT INTO `sys_logininfor` VALUES (339, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:47:03');
INSERT INTO `sys_logininfor` VALUES (340, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:48:36');
INSERT INTO `sys_logininfor` VALUES (341, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:52:05');
INSERT INTO `sys_logininfor` VALUES (342, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:56:02');
INSERT INTO `sys_logininfor` VALUES (343, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 10:56:50');
INSERT INTO `sys_logininfor` VALUES (344, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:00:15');
INSERT INTO `sys_logininfor` VALUES (345, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:21:58');
INSERT INTO `sys_logininfor` VALUES (346, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:23:04');
INSERT INTO `sys_logininfor` VALUES (347, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:28:32');
INSERT INTO `sys_logininfor` VALUES (348, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:29:23');
INSERT INTO `sys_logininfor` VALUES (349, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:33:17');
INSERT INTO `sys_logininfor` VALUES (350, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:34:08');
INSERT INTO `sys_logininfor` VALUES (351, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:35:59');
INSERT INTO `sys_logininfor` VALUES (352, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:37:08');
INSERT INTO `sys_logininfor` VALUES (353, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:38:52');
INSERT INTO `sys_logininfor` VALUES (354, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 11:48:43');
INSERT INTO `sys_logininfor` VALUES (355, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 13:56:05');
INSERT INTO `sys_logininfor` VALUES (356, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:00:24');
INSERT INTO `sys_logininfor` VALUES (357, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:01:45');
INSERT INTO `sys_logininfor` VALUES (358, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:03:38');
INSERT INTO `sys_logininfor` VALUES (359, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:04:28');
INSERT INTO `sys_logininfor` VALUES (360, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:06:50');
INSERT INTO `sys_logininfor` VALUES (361, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:10:10');
INSERT INTO `sys_logininfor` VALUES (362, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:13:42');
INSERT INTO `sys_logininfor` VALUES (363, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:14:46');
INSERT INTO `sys_logininfor` VALUES (364, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:20:18');
INSERT INTO `sys_logininfor` VALUES (365, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:21:41');
INSERT INTO `sys_logininfor` VALUES (366, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:23:10');
INSERT INTO `sys_logininfor` VALUES (367, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:23:56');
INSERT INTO `sys_logininfor` VALUES (368, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:25:52');
INSERT INTO `sys_logininfor` VALUES (369, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:27:01');
INSERT INTO `sys_logininfor` VALUES (370, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:28:15');
INSERT INTO `sys_logininfor` VALUES (371, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:29:11');
INSERT INTO `sys_logininfor` VALUES (372, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:35:39');
INSERT INTO `sys_logininfor` VALUES (373, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:36:44');
INSERT INTO `sys_logininfor` VALUES (374, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:37:40');
INSERT INTO `sys_logininfor` VALUES (375, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-12 14:44:25');
INSERT INTO `sys_logininfor` VALUES (376, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:44:29');
INSERT INTO `sys_logininfor` VALUES (377, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:45:37');
INSERT INTO `sys_logininfor` VALUES (378, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:47:15');
INSERT INTO `sys_logininfor` VALUES (379, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:49:04');
INSERT INTO `sys_logininfor` VALUES (380, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:51:36');
INSERT INTO `sys_logininfor` VALUES (381, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-12 14:52:46');
INSERT INTO `sys_logininfor` VALUES (382, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:52:48');
INSERT INTO `sys_logininfor` VALUES (383, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:57:05');
INSERT INTO `sys_logininfor` VALUES (384, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:58:09');
INSERT INTO `sys_logininfor` VALUES (385, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:59:00');
INSERT INTO `sys_logininfor` VALUES (386, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 14:59:48');
INSERT INTO `sys_logininfor` VALUES (387, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:04:18');
INSERT INTO `sys_logininfor` VALUES (388, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:14:03');
INSERT INTO `sys_logininfor` VALUES (389, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:15:29');
INSERT INTO `sys_logininfor` VALUES (390, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:15:57');
INSERT INTO `sys_logininfor` VALUES (391, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:17:02');
INSERT INTO `sys_logininfor` VALUES (392, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:21:59');
INSERT INTO `sys_logininfor` VALUES (393, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:23:01');
INSERT INTO `sys_logininfor` VALUES (394, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:23:28');
INSERT INTO `sys_logininfor` VALUES (395, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:25:20');
INSERT INTO `sys_logininfor` VALUES (396, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:26:22');
INSERT INTO `sys_logininfor` VALUES (397, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:27:07');
INSERT INTO `sys_logininfor` VALUES (398, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:27:25');
INSERT INTO `sys_logininfor` VALUES (399, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:28:23');
INSERT INTO `sys_logininfor` VALUES (400, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:29:30');
INSERT INTO `sys_logininfor` VALUES (401, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-12 15:30:12');
INSERT INTO `sys_logininfor` VALUES (402, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '1', '验证码错误', '2021-03-12 15:30:16');
INSERT INTO `sys_logininfor` VALUES (403, 'qsb', '127.0.0.1', '内网IP', 'Firefox 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:30:19');
INSERT INTO `sys_logininfor` VALUES (404, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误1次', '2021-03-12 15:43:23');
INSERT INTO `sys_logininfor` VALUES (405, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:43:36');
INSERT INTO `sys_logininfor` VALUES (406, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:45:36');
INSERT INTO `sys_logininfor` VALUES (407, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:47:40');
INSERT INTO `sys_logininfor` VALUES (408, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 15:48:52');
INSERT INTO `sys_logininfor` VALUES (409, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:31:12');
INSERT INTO `sys_logininfor` VALUES (410, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:33:18');
INSERT INTO `sys_logininfor` VALUES (411, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:35:31');
INSERT INTO `sys_logininfor` VALUES (412, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:39:10');
INSERT INTO `sys_logininfor` VALUES (413, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:40:50');
INSERT INTO `sys_logininfor` VALUES (414, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:44:07');
INSERT INTO `sys_logininfor` VALUES (415, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:46:32');
INSERT INTO `sys_logininfor` VALUES (416, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:48:19');
INSERT INTO `sys_logininfor` VALUES (417, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:51:41');
INSERT INTO `sys_logininfor` VALUES (418, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:57:06');
INSERT INTO `sys_logininfor` VALUES (419, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:58:10');
INSERT INTO `sys_logininfor` VALUES (420, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 16:59:40');
INSERT INTO `sys_logininfor` VALUES (421, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 17:07:12');
INSERT INTO `sys_logininfor` VALUES (422, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 17:11:00');
INSERT INTO `sys_logininfor` VALUES (423, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 17:20:09');
INSERT INTO `sys_logininfor` VALUES (424, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 17:37:39');
INSERT INTO `sys_logininfor` VALUES (425, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 17:41:18');
INSERT INTO `sys_logininfor` VALUES (426, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 17:44:07');
INSERT INTO `sys_logininfor` VALUES (427, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 17:51:51');
INSERT INTO `sys_logininfor` VALUES (428, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 18:13:48');
INSERT INTO `sys_logininfor` VALUES (429, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 18:15:30');
INSERT INTO `sys_logininfor` VALUES (430, 'qsb', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2021-03-12 18:18:38');
INSERT INTO `sys_logininfor` VALUES (431, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 18:18:43');
INSERT INTO `sys_logininfor` VALUES (432, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2021-03-12 18:19:14');
INSERT INTO `sys_logininfor` VALUES (433, '111', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误1次', '2021-03-12 18:19:28');
INSERT INTO `sys_logininfor` VALUES (434, '111', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '密码输入错误2次', '2021-03-12 18:19:30');
INSERT INTO `sys_logininfor` VALUES (435, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 18:20:39');
INSERT INTO `sys_logininfor` VALUES (436, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2021-03-12 18:21:46');
INSERT INTO `sys_logininfor` VALUES (437, 'qwe', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 18:21:52');
INSERT INTO `sys_logininfor` VALUES (438, 'qwe', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 18:24:51');
INSERT INTO `sys_logininfor` VALUES (439, 'qwe', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 18:27:17');
INSERT INTO `sys_logininfor` VALUES (440, 'qwe', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-03-12 18:29:09');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(0) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(0) NULL DEFAULT 0 COMMENT '显示顺序',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `is_refresh` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否刷新（0刷新 1不刷新）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2005 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, '#', '', 'M', '0', '1', '', 'fa fa-gear', 'admin', '2021-02-15 17:49:08', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, '#', '', 'M', '0', '1', '', 'fa fa-video-camera', 'admin', '2021-02-15 17:49:08', '', NULL, '系统监控目录');
INSERT INTO `sys_menu` VALUES (4, '选拔管理', 0, 4, '#', 'menuItem', 'M', '0', '', '', 'fa fa-line-chart', 'admin', '2021-02-27 16:53:22', 'admin', '2021-02-27 16:58:04', '教师端的选拔管理');
INSERT INTO `sys_menu` VALUES (5, '实践管理', 0, 5, '#', 'menuItem', 'M', '0', '', '', 'fa fa-bars', 'admin', '2021-02-27 16:56:26', 'admin', '2021-02-27 16:58:28', '教师端的实践管理');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, '/system/user', '', 'C', '0', '1', 'system:user:view', 'fa fa-user-o', 'admin', '2021-02-15 17:49:08', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, '/system/role', '', 'C', '0', '1', 'system:role:view', 'fa fa-user-secret', 'admin', '2021-02-15 17:49:08', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, '/system/menu', '', 'C', '0', '1', 'system:menu:view', 'fa fa-th-list', 'admin', '2021-02-15 17:49:08', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, '/system/notice', '', 'C', '0', '1', 'system:notice:view', 'fa fa-bullhorn', 'admin', '2021-02-15 17:49:08', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, '#', '', 'M', '0', '1', '', 'fa fa-pencil-square-o', 'admin', '2021-02-15 17:49:08', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, '/monitor/online', '', 'C', '0', '1', 'monitor:online:view', 'fa fa-user-circle', 'admin', '2021-02-15 17:49:08', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, '/monitor/operlog', '', 'C', '0', '1', 'monitor:operlog:view', 'fa fa-address-book', 'admin', '2021-02-15 17:49:08', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, '/monitor/logininfor', '', 'C', '0', '1', 'monitor:logininfor:view', 'fa fa-file-image-o', 'admin', '2021-02-15 17:49:08', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1000, '用户查询', 100, 1, '#', '', 'F', '0', '1', 'system:user:list', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1001, '用户新增', 100, 2, '#', '', 'F', '0', '1', 'system:user:add', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户修改', 100, 3, '#', '', 'F', '0', '1', 'system:user:edit', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户删除', 100, 4, '#', '', 'F', '0', '1', 'system:user:remove', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户导出', 100, 5, '#', '', 'F', '0', '1', 'system:user:export', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导入', 100, 6, '#', '', 'F', '0', '1', 'system:user:import', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '重置密码', 100, 7, '#', '', 'F', '0', '1', 'system:user:resetPwd', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '角色查询', 101, 1, '#', '', 'F', '0', '1', 'system:role:list', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色新增', 101, 2, '#', '', 'F', '0', '1', 'system:role:add', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色修改', 101, 3, '#', '', 'F', '0', '1', 'system:role:edit', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色删除', 101, 4, '#', '', 'F', '0', '1', 'system:role:remove', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色导出', 101, 5, '#', '', 'F', '0', '1', 'system:role:export', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '菜单查询', 102, 1, '#', '', 'F', '0', '1', 'system:menu:list', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单新增', 102, 2, '#', '', 'F', '0', '1', 'system:menu:add', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单修改', 102, 3, '#', '', 'F', '0', '1', 'system:menu:edit', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单删除', 102, 4, '#', '', 'F', '0', '1', 'system:menu:remove', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '公告查询', 107, 1, '#', '', 'F', '0', '1', 'system:notice:list', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告新增', 107, 2, '#', '', 'F', '0', '1', 'system:notice:add', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告修改', 107, 3, '#', '', 'F', '0', '1', 'system:notice:edit', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告删除', 107, 4, '#', '', 'F', '0', '1', 'system:notice:remove', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '操作查询', 500, 1, '#', '', 'F', '0', '1', 'monitor:operlog:list', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作删除', 500, 2, '#', '', 'F', '0', '1', 'monitor:operlog:remove', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '详细信息', 500, 3, '#', '', 'F', '0', '1', 'monitor:operlog:detail', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', 'F', '0', '1', 'monitor:operlog:export', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', 'F', '0', '1', 'monitor:logininfor:list', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', 'F', '0', '1', 'monitor:logininfor:remove', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', 'F', '0', '1', 'monitor:logininfor:export', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '账户解锁', 501, 4, '#', '', 'F', '0', '1', 'monitor:logininfor:unlock', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '在线查询', 109, 1, '#', '', 'F', '0', '1', 'monitor:online:list', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '批量强退', 109, 2, '#', '', 'F', '0', '1', 'monitor:online:batchForceLogout', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '单条强退', 109, 3, '#', '', 'F', '0', '1', 'monitor:online:forceLogout', '#', 'admin', '2021-02-15 17:49:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2000, '提交成绩', 4, 1, '/teacher/commit', 'menuItem', 'C', '0', '0', 'teacher:commit:view', 'fa fa-sort-alpha-asc', 'admin', '2021-02-27 17:07:16', 'admin', '2021-02-27 17:08:24', '');
INSERT INTO `sys_menu` VALUES (2001, '双选对接', 5, 1, '/teacher/choice', 'menuItem', 'C', '0', '1', 'techaer:choice:view', 'fa fa-handshake-o', 'admin', '2021-02-27 17:10:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2003, '我的学生', 5, 2, '#', 'menuItem', 'M', '0', '1', NULL, 'fa fa-user', 'admin', '2021-02-27 17:14:36', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2004, '成绩管理', 2003, 1, '/teacher/mystu', 'menuItem', 'C', '0', '1', 'teacher:mystu:view', 'fa fa-sort-numeric-asc', 'admin', '2021-02-27 17:15:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2005, '学生查询', 2004, 1, '#', 'menuItem', 'F', '0', '1', 'teacher:mystu:list', '#', 'admin', '2021-02-28 14:31:17', '', NULL, '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', '2021-02-15 17:49:16', '', NULL, '管理员');
INSERT INTO `sys_notice` VALUES (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', '2021-02-15 17:49:16', '', NULL, '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(0) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(0) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(0) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (100, '用户管理', 1, 'com.es.web.controller.system.SysUserController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/user/add', '127.0.0.1', '内网IP', '{\"deptId\":[\"103\"],\"userName\":[\"qishuaibin\"],\"deptName\":[\"研发部门\"],\"phonenumber\":[\"15812312311\"],\"email\":[\"281720223@qq.com\"],\"loginName\":[\"qsb\"],\"sex\":[\"0\"],\"role\":[\"2\"],\"remark\":[\"\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"1\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-23 17:42:01');
INSERT INTO `sys_oper_log` VALUES (101, '用户管理', 1, 'com.es.web.controller.system.SysUserController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/user/add', '127.0.0.1', '内网IP', '{\"deptId\":[\"104\"],\"userName\":[\"111\"],\"deptName\":[\"市场部门\"],\"phonenumber\":[\"15651231231\"],\"email\":[\"2817123213@qq.com\"],\"loginName\":[\"111\"],\"sex\":[\"0\"],\"role\":[\"2\"],\"remark\":[\"\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"1\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 12:25:24');
INSERT INTO `sys_oper_log` VALUES (102, '菜单管理', 2, 'com.es.web.controller.system.SysMenuController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"5\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"选拔管理\"],\"url\":[\"#\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"5\"],\"icon\":[\"fa fa-line-chart\"],\"visible\":[\"0\"],\"isRefresh\":[\"\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 16:58:05');
INSERT INTO `sys_oper_log` VALUES (103, '菜单管理', 2, 'com.es.web.controller.system.SysMenuController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"6\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"实践管理\"],\"url\":[\"#\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"6\"],\"icon\":[\"fa fa-bars\"],\"visible\":[\"0\"],\"isRefresh\":[\"\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 16:58:29');
INSERT INTO `sys_oper_log` VALUES (104, '菜单管理', 1, 'com.es.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"5\"],\"menuType\":[\"C\"],\"menuName\":[\"提交成绩\"],\"url\":[\"/teacher/commit\"],\"target\":[\"menuItem\"],\"perms\":[\"teacher:commit:view\"],\"orderNum\":[\"1\"],\"icon\":[\"fa fa-sort-alpha-asc\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 17:07:16');
INSERT INTO `sys_oper_log` VALUES (105, '菜单管理', 2, 'com.es.web.controller.system.SysMenuController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2000\"],\"parentId\":[\"5\"],\"menuType\":[\"C\"],\"menuName\":[\"提交成绩\"],\"url\":[\"/teacher/commit\"],\"target\":[\"menuItem\"],\"perms\":[\"teacher:commit:view\"],\"orderNum\":[\"1\"],\"icon\":[\"fa fa-sort-alpha-asc\"],\"visible\":[\"0\"],\"isRefresh\":[\"0\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 17:08:24');
INSERT INTO `sys_oper_log` VALUES (106, '菜单管理', 1, 'com.es.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"6\"],\"menuType\":[\"C\"],\"menuName\":[\"双选对接\"],\"url\":[\"/teacher/choice\"],\"target\":[\"menuItem\"],\"perms\":[\"techaer:choice:view\"],\"orderNum\":[\"1\"],\"icon\":[\"fa fa-handshake-o\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 17:10:41');
INSERT INTO `sys_oper_log` VALUES (107, '菜单管理', 1, 'com.es.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"6\"],\"menuType\":[\"C\"],\"menuName\":[\"我的学生\"],\"url\":[\"/teacher/mystu\"],\"target\":[\"menuItem\"],\"perms\":[\"teacher:mystu:view\"],\"orderNum\":[\"2\"],\"icon\":[\"fa fa-handshake-o\"],\"visible\":[\"0\"],\"isRefresh\":[\"0\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 17:12:28');
INSERT INTO `sys_oper_log` VALUES (108, '菜单管理', 2, 'com.es.web.controller.system.SysMenuController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2002\"],\"parentId\":[\"6\"],\"menuType\":[\"M\"],\"menuName\":[\"我的学生\"],\"url\":[\"/teacher/mystu\"],\"target\":[\"menuItem\"],\"perms\":[\"teacher:mystu:view\"],\"orderNum\":[\"2\"],\"icon\":[\"fa fa-handshake-o\"],\"visible\":[\"0\"],\"isRefresh\":[\"\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 17:13:15');
INSERT INTO `sys_oper_log` VALUES (109, '菜单管理', 3, 'com.es.web.controller.system.SysMenuController.remove()', 'GET', 1, 'admin', '研发部门', '/system/menu/remove/2002', '127.0.0.1', '内网IP', NULL, '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 17:14:07');
INSERT INTO `sys_oper_log` VALUES (110, '菜单管理', 1, 'com.es.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"6\"],\"menuType\":[\"M\"],\"menuName\":[\"我的学生\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"2\"],\"icon\":[\"fa fa-user\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 17:14:37');
INSERT INTO `sys_oper_log` VALUES (111, '菜单管理', 1, 'com.es.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"2003\"],\"menuType\":[\"C\"],\"menuName\":[\"成绩管理\"],\"url\":[\"/teacher/mystu\"],\"target\":[\"menuItem\"],\"perms\":[\"teacher:mystu:view\"],\"orderNum\":[\"1\"],\"icon\":[\"fa fa-sort-numeric-asc\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-27 17:15:41');
INSERT INTO `sys_oper_log` VALUES (112, '菜单管理', 1, 'com.es.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"2004\"],\"menuType\":[\"F\"],\"menuName\":[\"学生查询\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"teacher:mystu:list\"],\"orderNum\":[\"1\"],\"icon\":[\"\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-02-28 14:31:17');
INSERT INTO `sys_oper_log` VALUES (113, '在线用户', 7, 'com.es.web.controller.monitor.SysUserOnlineController.batchForceLogout()', 'POST', 1, 'admin', '研发部门', '/monitor/online/batchForceLogout', '127.0.0.1', '内网IP', '{\"ids\":[\"bb76cee3-6cd2-40f9-8264-c0b22b229ffe\"]}', '{\r\n  \"msg\" : \"当前登录用户无法强退\",\r\n  \"code\" : 500\r\n}', 0, NULL, '2021-03-02 15:33:36');
INSERT INTO `sys_oper_log` VALUES (114, '在线用户', 7, 'com.es.web.controller.monitor.SysUserOnlineController.batchForceLogout()', 'POST', 1, 'admin', '研发部门', '/monitor/online/batchForceLogout', '127.0.0.1', '内网IP', '{\"ids\":[\"46b8b66d-e95c-4080-8bae-639a9072c812\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-03-02 15:36:21');
INSERT INTO `sys_oper_log` VALUES (115, '个人信息', 2, 'com.es.web.controller.system.SysProfileController.updateAvatar()', 'POST', 1, 'admin', '研发部门', '/system/user/profile/updateAvatar', '127.0.0.1', '内网IP', NULL, '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-03-03 16:16:23');
INSERT INTO `sys_oper_log` VALUES (116, '重置密码', 2, 'com.es.web.controller.system.SysProfileController.resetPwd()', 'POST', 1, 'qsb', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{}', '{\r\n  \"msg\" : \"新密码不能与旧密码相同\",\r\n  \"code\" : 500\r\n}', 0, NULL, '2021-03-12 15:33:27');
INSERT INTO `sys_oper_log` VALUES (117, '重置密码', 2, 'com.es.web.controller.system.SysProfileController.resetPwd()', 'POST', 1, 'qsb', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{}', '{\r\n  \"msg\" : \"新密码不能与旧密码相同\",\r\n  \"code\" : 500\r\n}', 0, NULL, '2021-03-12 15:33:29');
INSERT INTO `sys_oper_log` VALUES (118, '重置密码', 2, 'com.es.web.controller.system.SysProfileController.resetPwd()', 'POST', 1, 'qsb', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-03-12 15:33:41');
INSERT INTO `sys_oper_log` VALUES (119, '重置密码', 2, 'com.es.web.controller.system.SysProfileController.resetPwd()', 'POST', 1, 'qsb', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', '内网IP', '{}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-03-12 15:34:03');
INSERT INTO `sys_oper_log` VALUES (120, '用户管理', 1, 'com.es.web.controller.system.SysUserController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/user/add', '127.0.0.1', '内网IP', '{\"deptId\":[\"\"],\"userName\":[\"末日铁拳 \"],\"deptName\":[\"\"],\"phonenumber\":[\"\"],\"email\":[\"\"],\"loginName\":[\"qwe\"],\"sex\":[\"0\"],\"role\":[\"3\"],\"remark\":[\"\"],\"status\":[\"0\"],\"roleIds\":[\"3\"],\"postIds\":[\"1\"]}', '{\r\n  \"msg\" : \"操作成功\",\r\n  \"code\" : 0\r\n}', 0, NULL, '2021-03-12 18:21:35');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(0) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2021-02-15 17:49:06', '', NULL, '');
INSERT INTO `sys_post` VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2021-02-15 17:49:06', '', NULL, '');
INSERT INTO `sys_post` VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2021-02-15 17:49:06', '', NULL, '');
INSERT INTO `sys_post` VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2021-02-15 17:49:06', '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(0) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', '0', '0', 'admin', '2021-02-15 17:49:07', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', '0', '0', 'admin', '2021-02-15 17:49:07', '', NULL, '普通角色');
INSERT INTO `sys_role` VALUES (3, '教师', 'teacher', 1, '2', '0', '0', 'admin', '2021-02-27 17:23:49', '', NULL, '教师角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(0) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(0) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (2, 100);
INSERT INTO `sys_role_dept` VALUES (2, 101);
INSERT INTO `sys_role_dept` VALUES (2, 105);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(0) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(0) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1000);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);
INSERT INTO `sys_role_menu` VALUES (2, 1061);
INSERT INTO `sys_role_menu` VALUES (3, 4);
INSERT INTO `sys_role_menu` VALUES (3, 5);
INSERT INTO `sys_role_menu` VALUES (3, 2000);
INSERT INTO `sys_role_menu` VALUES (3, 2001);
INSERT INTO `sys_role_menu` VALUES (3, 2003);
INSERT INTO `sys_role_menu` VALUES (3, 2004);
INSERT INTO `sys_role_menu` VALUES (3, 2005);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(0) NULL DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户 01教师用户 02学生用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '盐加密',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `pwd_update_date` datetime(0) NULL DEFAULT NULL COMMENT '密码最后更新时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '/profile/avatar/2021/03/03/a24c2771-5292-4cb7-9dca-02ecb6b06115.png', '29c67a30398638269fe600f73a054934', '111111', '0', '0', '127.0.0.1', '2021-03-12 18:20:39', '2021-02-15 17:49:06', 'admin', '2021-02-15 17:49:06', '', '2021-03-12 18:20:39', '管理员');
INSERT INTO `sys_user` VALUES (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '0', '127.0.0.1', '2021-02-15 17:49:06', '2021-02-15 17:49:06', 'admin', '2021-02-15 17:49:06', '', NULL, '测试员');
INSERT INTO `sys_user` VALUES (100, 103, 'qsb', 'qishuaibin', '01', '281720223@qq.com', '15812312311', '0', '', 'a528ed90c411cd12feae33de93d08e36', 'e53a2f', '0', '0', '127.0.0.1', '2021-03-12 18:15:30', '2021-03-12 15:34:03', 'admin', '2021-02-23 17:42:00', '', '2021-03-12 18:15:29', NULL);
INSERT INTO `sys_user` VALUES (101, 104, '111', '111', '00', '2817123213@qq.com', '15651231231', '0', '', '592891524ab920affa125c556d35bb77', '9716e9', '0', '0', '', NULL, NULL, 'admin', '2021-02-27 12:25:23', '', NULL, NULL);
INSERT INTO `sys_user` VALUES (102, NULL, 'qwe', '末日铁拳', '01', '', '', '0', '', '9fea6a349005a2ce0f8737e5a81472bf', 'd6f590', '0', '0', '127.0.0.1', '2021-03-12 18:29:09', NULL, 'admin', '2021-03-12 18:21:35', '', '2021-03-12 18:29:09', NULL);

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online`  (
  `sessionId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime(0) NULL DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime(0) NULL DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(0) NULL DEFAULT 0 COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '在线用户记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_online
-- ----------------------------
INSERT INTO `sys_user_online` VALUES ('9029745e-126f-4580-abc8-ff9cf05ddd47', 'qwe', NULL, '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', 'on_line', '2021-03-12 18:21:47', '2021-03-12 18:29:09', 1800000);

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `post_id` bigint(0) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (2, 2);
INSERT INTO `sys_user_post` VALUES (100, 1);
INSERT INTO `sys_user_post` VALUES (101, 1);
INSERT INTO `sys_user_post` VALUES (102, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `role_id` bigint(0) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (100, 3);
INSERT INTO `sys_user_role` VALUES (101, 3);
INSERT INTO `sys_user_role` VALUES (102, 3);

-- ----------------------------
-- Table structure for tea_course
-- ----------------------------
DROP TABLE IF EXISTS `tea_course`;
CREATE TABLE `tea_course`  (
  `course_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '课程主键',
  `course_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `course_type` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类型',
  `status` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_course
-- ----------------------------
INSERT INTO `tea_course` VALUES (1, 'C语言程序与设计', '1', '0', 'admin', '2021-03-06 14:12:05', 'admin', '2021-03-06 14:12:12', NULL);
INSERT INTO `tea_course` VALUES (2, '计算机专业导论', '2', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (3, 'Java程序设计', '1', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (4, 'Linux操作系统', '4', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (5, '软件工程', '3', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (6, 'Java高级程序设计   ', '1', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (7, 'Hadoop系统与开发', '1', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (8, 'Flash动画设计与制作', '2', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (9, 'Spark系统与开发', '1', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (10, '数据结构', '2', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (11, 'XML基础及应用', '2', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (12, 'JavaWeb程序设计', '1', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (13, '局域网组网技术', '2', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (14, '操作系统', '2', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (15, '计算机组成原理', '2', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (16, 'Python程序设计', '1', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (17, '计算机网络', '2', '0', NULL, NULL, '', NULL, NULL);
INSERT INTO `tea_course` VALUES (18, '网页设计与制作', '3', '0', NULL, NULL, '', NULL, NULL);

-- ----------------------------
-- Table structure for tea_course_type
-- ----------------------------
DROP TABLE IF EXISTS `tea_course_type`;
CREATE TABLE `tea_course_type`  (
  `type_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `course_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类型名称',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_course_type
-- ----------------------------
INSERT INTO `tea_course_type` VALUES (1, '专业编程类');
INSERT INTO `tea_course_type` VALUES (2, '专业理论类');
INSERT INTO `tea_course_type` VALUES (3, '专业拓展类');
INSERT INTO `tea_course_type` VALUES (4, '专业操作类');

-- ----------------------------
-- Table structure for tea_profess
-- ----------------------------
DROP TABLE IF EXISTS `tea_profess`;
CREATE TABLE `tea_profess`  (
  `profess_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '职称主键',
  `profess_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称名称',
  `max_stu` int(0) NULL DEFAULT NULL COMMENT '每个年级可选的最大学生数',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`profess_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_profess
-- ----------------------------
INSERT INTO `tea_profess` VALUES (1, '教授', 4, '0', 'admin', '2021-02-27 16:31:09');
INSERT INTO `tea_profess` VALUES (2, '副教授', 3, '0', 'admin', '2021-02-27 16:31:57');
INSERT INTO `tea_profess` VALUES (3, '讲师', 2, '0', 'admin', '2021-02-27 16:32:17');
INSERT INTO `tea_profess` VALUES (4, '助教', 1, '0', 'admin', '2021-02-27 16:32:33');

-- ----------------------------
-- Table structure for tea_stu_rel
-- ----------------------------
DROP TABLE IF EXISTS `tea_stu_rel`;
CREATE TABLE `tea_stu_rel`  (
  `tea_id` int(0) NULL DEFAULT NULL COMMENT '教师id',
  `stu_id` int(0) NULL DEFAULT NULL COMMENT '学生id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_stu_rel
-- ----------------------------
INSERT INTO `tea_stu_rel` VALUES (100, 1);
INSERT INTO `tea_stu_rel` VALUES (100, 2);

-- ----------------------------
-- Table structure for tea_user
-- ----------------------------
DROP TABLE IF EXISTS `tea_user`;
CREATE TABLE `tea_user`  (
  `tea_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '教师主键（与sys_user主键对应）',
  `tea_profess` int(0) NOT NULL COMMENT '教师职称（与tea_profess主键对应）',
  `tea_job_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师工号',
  `status` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态（0正常 1停用）',
  PRIMARY KEY (`tea_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_user
-- ----------------------------
INSERT INTO `tea_user` VALUES (100, 1, '201719244203', '0');
INSERT INTO `tea_user` VALUES (102, 2, '123123123123', '0');

-- ----------------------------
-- Table structure for tea_user_course
-- ----------------------------
DROP TABLE IF EXISTS `tea_user_course`;
CREATE TABLE `tea_user_course`  (
  `tea_id` int(0) NULL DEFAULT NULL COMMENT '教师id',
  `course_id` int(0) NULL DEFAULT NULL COMMENT '课程id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_user_course
-- ----------------------------
INSERT INTO `tea_user_course` VALUES (100, 3);
INSERT INTO `tea_user_course` VALUES (100, 6);
INSERT INTO `tea_user_course` VALUES (100, 16);
INSERT INTO `tea_user_course` VALUES (102, 1);
INSERT INTO `tea_user_course` VALUES (102, 12);
INSERT INTO `tea_user_course` VALUES (102, 4);

SET FOREIGN_KEY_CHECKS = 1;
