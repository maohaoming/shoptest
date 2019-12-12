/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-12 14:33:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_brand
-- ----------------------------
DROP TABLE IF EXISTS `pms_brand`;
CREATE TABLE `pms_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `brand_name` varchar(32) DEFAULT NULL COMMENT '品牌名称',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `brand_factory_status` varchar(1) DEFAULT NULL COMMENT '是否是品牌制造商 1->是 2->否',
  `show_status` tinyint(1) DEFAULT NULL COMMENT '是否显示 0->否 1->是',
  `del_status` varchar(1) DEFAULT NULL COMMENT '是否删除  0->未删除  1->删除',
  `brand_logo_pic` varchar(255) DEFAULT NULL COMMENT '品牌logo图片',
  `show_pic` varchar(255) DEFAULT NULL COMMENT '封面图片',
  `brand_story` text COMMENT '品牌故事',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_brand
-- ----------------------------
INSERT INTO `pms_brand` VALUES ('1', '品牌1号', '22', '1', '1', '0', null, null, '品牌1号故事', '2019-12-04 11:52:47', null, '2019-12-04 11:52:50', null);

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品信息表id',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌id',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类id',
  `feight_template_id` bigint(20) DEFAULT NULL COMMENT '运费模板id',
  `product_attribute_category_id` bigint(20) DEFAULT NULL COMMENT '规格属性类别id',
  `name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '商品主图',
  `product_sn` varchar(64) DEFAULT NULL COMMENT '货号',
  `publish_status` tinyint(1) DEFAULT NULL COMMENT '是否上架 0->下架  1->上架',
  `recommand_status` tinyint(1) DEFAULT NULL COMMENT '是否推荐  0->否  1->是',
  `verify_status` int(1) DEFAULT NULL COMMENT '审核状态  0->待审核  1->审核通过  2->审核拒绝',
  `sale_count` decimal(10,2) DEFAULT NULL COMMENT '销量',
  `unit` varchar(16) DEFAULT NULL COMMENT '单位',
  `min_price` decimal(10,2) DEFAULT NULL COMMENT '最低价',
  `max_price` decimal(10,2) DEFAULT NULL COMMENT '最高价',
  `market_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `description` longtext COMMENT '商品描述',
  `stock_total` decimal(10,2) DEFAULT NULL COMMENT '库存总数',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '重量(单位默认为克)',
  `album_pics` longtext COMMENT '画册图片，限制为5张，以逗号分割，主图在第一位',
  `detail_title` varchar(64) DEFAULT NULL COMMENT '商品详情标题',
  `detail_sub_title` varchar(64) DEFAULT NULL COMMENT '商品详情副标题',
  `detail_html` longtext COMMENT '商品详情富文本',
  `del_status` int(1) DEFAULT NULL,
  `sort` int(18) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product
-- ----------------------------
INSERT INTO `pms_product` VALUES ('1', '1', '1', '1', '1', '华为手机Meto20', null, 'A111111', '1', '1', '1', '50.00', '件', '4900.00', '6900.00', '5500.00', '华为旗下的一款最牛逼的手机', '100.00', '75.00', null, '华为手机', '华为牛逼手机', null, '0', '1', '2019-12-04 11:57:12', null, '2019-12-04 11:57:16', null);

-- ----------------------------
-- Table structure for pms_product_attribute
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute`;
CREATE TABLE `pms_product_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品规格属性表id',
  `product_attribute_category_id` bigint(20) DEFAULT NULL COMMENT '规格属性类别id',
  `name` varchar(64) DEFAULT NULL COMMENT '规格属性名称',
  `type` int(1) DEFAULT NULL COMMENT '类型 0->规格属性  1->参数',
  `sort` int(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `del_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product_attribute
-- ----------------------------
INSERT INTO `pms_product_attribute` VALUES ('1', '1', '颜色', '0', '0', '2019-12-04 11:58:15', null, '2019-12-04 11:58:29', null, '0');
INSERT INTO `pms_product_attribute` VALUES ('2', '1', '尺寸', '0', '1', '2019-12-04 11:58:50', null, '2019-12-04 11:58:53', null, '0');

-- ----------------------------
-- Table structure for pms_product_attribute_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_category`;
CREATE TABLE `pms_product_attribute_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品规格属性类别表id',
  `name` varchar(64) DEFAULT NULL COMMENT '类别名称',
  `attribute_count` int(16) DEFAULT NULL COMMENT '类别下属性数量',
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `sort` int(16) DEFAULT NULL,
  `del_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product_attribute_category
-- ----------------------------
INSERT INTO `pms_product_attribute_category` VALUES ('1', '颜色+尺寸', '2', '2019-12-04 11:54:38', null, '2019-12-04 11:54:40', null, '0', '0');

-- ----------------------------
-- Table structure for pms_product_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_value`;
CREATE TABLE `pms_product_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品规格属性值id',
  `product_attribute_id` bigint(20) DEFAULT NULL COMMENT '商品规格属性id',
  `value` varchar(64) DEFAULT NULL COMMENT '属性值',
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `del_status` int(1) DEFAULT NULL,
  `sort` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product_attribute_value
-- ----------------------------
INSERT INTO `pms_product_attribute_value` VALUES ('1', '1', '红色', '2019-12-04 11:59:21', null, '2019-12-04 11:59:25', null, '0', '0');
INSERT INTO `pms_product_attribute_value` VALUES ('2', '1', '绿色', '2019-12-04 11:59:42', null, '2019-12-04 11:59:47', null, '0', '0');
INSERT INTO `pms_product_attribute_value` VALUES ('3', '1', '蓝色', '2019-12-04 12:00:57', null, '2019-12-04 12:00:59', null, '0', '0');
INSERT INTO `pms_product_attribute_value` VALUES ('4', '2', '4G', '2019-12-04 12:01:13', null, '2019-12-04 12:01:15', null, '0', '1');
INSERT INTO `pms_product_attribute_value` VALUES ('5', '2', '8G', '2019-12-04 12:01:29', null, '2019-12-04 12:01:33', null, '0', '1');
INSERT INTO `pms_product_attribute_value` VALUES ('6', '2', '16G', '2019-12-04 12:01:46', null, '2019-12-04 12:01:49', null, '0', '1');

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `icon` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态  0->禁用  1->启用',
  `sort` int(18) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL COMMENT '最后一次登陆时间',
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `del_status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES ('7', 'admin', '$2a$10$z9sdeWycxNm.iwHczk76GOlOC0/I8zQ64oYOjKZ96HJgIG9qvq366', null, null, null, null, '1', null, null, '2019-11-22 12:23:01', null, '2019-11-22 12:23:01', null, '0');
INSERT INTO `ums_admin` VALUES ('8', 'test', '$2a$10$KTKU3acVYgnvoWY.hpLcju/nsi0TfCV6KItgP1caqDoVUOSf6TONS', null, null, null, null, '1', null, null, '2019-11-22 15:26:56', null, '2019-11-22 15:26:56', null, '0');

-- ----------------------------
-- Table structure for ums_admin_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_permission_relation`;
CREATE TABLE `ums_admin_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户权限关系表id',
  `admin_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `del_status` varchar(1) DEFAULT NULL,
  `sort` int(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ums_admin_permission_relation
-- ----------------------------
INSERT INTO `ums_admin_permission_relation` VALUES ('1', '7', '1', '2019-11-22 12:37:32', null, '2019-11-22 12:37:34', null, '0', '0');
INSERT INTO `ums_admin_permission_relation` VALUES ('2', '8', '1', '2019-11-22 15:45:20', null, '2019-11-22 15:45:24', null, '0', '0');

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色关系表id',
  `admin_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `del_status` varchar(1) DEFAULT NULL,
  `sort` int(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO `ums_admin_role_relation` VALUES ('1', '7', '1', '2019-11-22 13:32:21', null, '2019-11-22 13:32:23', null, '0', '0');

-- ----------------------------
-- Table structure for ums_permission
-- ----------------------------
DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限表id',
  `pid` bigint(20) DEFAULT NULL COMMENT '父id',
  `per_name` varchar(64) DEFAULT NULL COMMENT '名称',
  `pre_value` varchar(64) DEFAULT NULL COMMENT '值',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `per_type` int(1) DEFAULT NULL COMMENT '类型  0->目录 1->菜单 2->按钮',
  `per_path` varchar(255) DEFAULT NULL COMMENT '资源路由',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态 0->禁用 1->启用',
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `del_status` varchar(1) DEFAULT NULL,
  `sort` int(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ums_permission
-- ----------------------------
INSERT INTO `ums_permission` VALUES ('1', '5', '品牌管理', 'pms:brand:read', null, '1', '/pms/brand/index', '1', '2019-11-22 12:25:56', null, '2019-11-22 12:26:00', null, '0', '0');
INSERT INTO `ums_permission` VALUES ('2', '1', '添加品牌', 'pms:brand:create', null, '2', '/pms/brand/add', '1', '2019-11-22 12:29:30', null, '2019-11-22 12:29:33', null, '0', '1');
INSERT INTO `ums_permission` VALUES ('3', '1', '修改品牌', 'pms:brand:update', null, '2', '/pms/brand/update', '1', '2019-11-22 12:34:17', null, '2019-11-22 12:34:20', null, '0', '2');
INSERT INTO `ums_permission` VALUES ('4', '1', '删除品牌', 'pms:brand:delete', null, '2', '/pms/brand/delete', '1', '2019-11-22 12:35:04', null, '2019-11-22 12:35:06', null, '0', '3');
INSERT INTO `ums_permission` VALUES ('5', '0', '商品', null, null, '0', null, '1', '2019-11-22 12:35:41', null, '2019-11-22 12:35:43', null, '0', '4');

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色表id',
  `role_name` varchar(64) DEFAULT NULL COMMENT '名称',
  `role_code` varchar(18) DEFAULT NULL COMMENT '编号',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `admin_count` int(18) DEFAULT NULL COMMENT '用户数量',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态  0->禁用  1->启用',
  `sort` int(18) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `del_status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ums_role
-- ----------------------------

-- ----------------------------
-- Table structure for ums_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_permission_relation`;
CREATE TABLE `ums_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色权限表id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  `create_time` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier_id` bigint(20) DEFAULT NULL,
  `del_status` varchar(1) DEFAULT NULL,
  `sort` int(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ums_role_permission_relation
-- ----------------------------
