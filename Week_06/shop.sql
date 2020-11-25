/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50647
Source Host           : 127.0.0.1:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50647
File Encoding         : 65001

Date: 2020-11-25 22:10:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_default` double DEFAULT NULL COMMENT '默认地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `seller_id` varchar(50) DEFAULT NULL COMMENT '卖家ID',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名',
  `price` decimal(10,0) DEFAULT NULL COMMENT '商品价格',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片',
  `describe` varchar(2000) DEFAULT NULL COMMENT '描述',
  `stock` int(10) DEFAULT NULL COMMENT '库存',
  `sale_num` int(10) DEFAULT NULL COMMENT '销售量',
  `price_now` decimal(10,0) DEFAULT NULL COMMENT '活动价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_goods_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_snapshot`;
CREATE TABLE `tb_goods_snapshot` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `seller_id` varchar(50) DEFAULT NULL COMMENT '卖家ID',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名',
  `price` decimal(10,0) DEFAULT NULL COMMENT '商品价格',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片',
  `describe` varchar(2000) DEFAULT NULL COMMENT '描述',
  `stock` int(10) DEFAULT NULL COMMENT '库存',
  `sale_num` int(10) DEFAULT NULL COMMENT '销售量',
  `goods_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `price_now` decimal(10,0) DEFAULT NULL COMMENT '活动价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `seller_id` varchar(50) DEFAULT NULL COMMENT '店家ID',
  `goods_snapshot_id` varchar(50) DEFAULT NULL COMMENT '商品快照ID',
  `address_id` varchar(50) DEFAULT NULL COMMENT '地址ID',
  `num` int(11) DEFAULT NULL COMMENT '购买数量',
  `price_total` decimal(10,0) DEFAULT NULL COMMENT '总价',
  `pay_type` varchar(50) DEFAULT NULL COMMENT '支付方式',
  `pay_price` decimal(10,0) DEFAULT NULL COMMENT '支付价格',
  `pay_url` varchar(255) DEFAULT NULL COMMENT '支付记录',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_seller
-- ----------------------------
DROP TABLE IF EXISTS `tb_seller`;
CREATE TABLE `tb_seller` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `name` varchar(255) DEFAULT NULL COMMENT '店名',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
