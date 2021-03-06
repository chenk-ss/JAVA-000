###第六周作业：  
一.基于电商交易场景（用户、商品、订单），设计一套简单的表结构  
共设计了六张表：  
1.用户表：
```sql
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
```

2.收货地址表：  
```sql
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
```

3.商家表：  
```sql
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
```

4.商品表：  
```sql
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
```

5.商品快照表：
```sql
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
```

6.订单表：  
```sql
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
```