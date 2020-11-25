CREATE TABLE `good_brand_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `cat_id` bigint AS () COMMENT '商品类别ID' NULL,
  `brand_code` varchar(32) AS () COMMENT '品牌编码' NULL,
  `brand_name` varchar(64) AS () COMMENT '品牌名称' NULL,
  `logo_url` varchar(255) AS () COMMENT 'logo地址' NULL,
  `en_name` varchar(255) NULL COMMENT '英文名称',
  `first_letter` varchar(5) NULL COMMENT '首字母',
  `remark` varchar(255) NULL COMMENT '备注',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '是否禁用 0否 1是',
  `is_delete` tinyint(1) NULL,
  `gmt_create` bigint NULL,
  `create_by` varchar(32) NULL,
  `gmt_update` bigint NULL,
  `update_by` varchar(32) NULL,
  PRIMARY KEY (`id`)
) COMMENT = '商品品牌表';

CREATE TABLE `good_cat_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `cat_code` varchar(64) NOT NULL COMMENT '商品类别编码',
  `cat_name` varchar(64) NOT NULL COMMENT '商品类别名称',
  `seq` int NOT NULL COMMENT '商品类别排序',
  `remark` text NULL COMMENT '商品类别备注',
  `parent_cat_id` bigint NULL COMMENT '父级商品类别ID',
  `status` tinyint(1) NULL COMMENT '是否启用 0否1是',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除 0否 1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  `gmt_update` bigint NOT NULL COMMENT '更新时间',
  `update_by` varchar(32) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) COMMENT = '商品类别表';

CREATE TABLE `good_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `good_name` varchar(255) NOT NULL COMMENT '商品名称',
  `good_cat_id` bigint NOT NULL COMMENT '类别ID',
  `good_brand_id` bigint NOT NULL COMMENT '品牌ID',
  `good_unit_id` bigint NOT NULL COMMENT '商品单位ID',
  `good_price` bigint NOT NULL COMMENT '商品价格',
  `is_presell` tinyint(1) NULL DEFAULT 0 COMMENT '是否为预售 0否 1是',
  `alias_name` varchar(64) NULL COMMENT '别名',
  `short_code` varchar(32) NULL COMMENT '速记代码',
  `remark` varchar(4000) NULL COMMENT '备注',
  `img_url` varchar(255) NOT NULL COMMENT '主图片路径',
  `tax_rate` decimal(6, 2) NULL COMMENT '税率',
  `store_up_limit` bigint NULL COMMENT '库存上限',
  `store_down_limit` bigint NULL COMMENT '库存下限',
  `upper_time` bigint NULL COMMENT '上架时间',
  `lower_time` bigint NULL COMMENT '下架时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '是否允许售卖 0否 1是',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除 0否 1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  `gmt_update` bigint NOT NULL COMMENT '更新时间',
  `update_by` varchar(32) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) COMMENT = '商品基础信息表';

CREATE TABLE `good_unit_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `unit_code` varchar(32) NOT NULL COMMENT '单位编码',
  `unit_name` varchar(32) NOT NULL COMMENT '单位名称',
  `unit_mark` varchar(16) NOT NULL COMMENT '单位符号',
  `remark` varchar(255) NULL COMMENT '备注',
  `base_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否基本单位 0否 1是',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  `gmt_update` bigint NOT NULL COMMENT '更新时间',
  `update_by` varchar(32) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) COMMENT = '商品单位表';

CREATE TABLE `goods_stock_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NULL COMMENT '租户ID',
  `merchant_id` bigint NULL COMMENT '商户ID',
  `good_id` bigint NULL COMMENT '商品ID',
  `good_stock` bigint NULL COMMENT '库存数量 最大支持到小数量后2位',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单库存表';

CREATE TABLE `order_coupon_extend_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `coupon_id` bigint NOT NULL COMMENT '优惠ID',
  `key_code` varchar(64) NULL COMMENT '扩展属性编码',
  `key_name` varchar(64) NULL COMMENT '扩展属性名称',
  `key_value` text NULL COMMENT '扩展属性内容',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单优惠扩展表';

CREATE TABLE `order_coupon_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `coupon_code` varchar(32) NOT NULL COMMENT '优惠编码',
  `coupon_name` varchar(32) NOT NULL COMMENT '优惠名称',
  `coupon_type` tinyint(1) NOT NULL COMMENT '优惠类型 1优惠活动 2券优惠',
  `main_coupon_code` varchar(32) NOT NULL COMMENT '主优惠编码',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单优惠信息表';

CREATE TABLE `order_distribution_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `order_dis_number_id` bigint NOT NULL COMMENT '订单物流单号ID',
  `distribu_status` tinyint(1) NOT NULL COMMENT '物流状态 0待揽收 1已揽收 2发往分拨 3分拨 4分拨完成下一站 5 即将配送 6已收货 7存放驿站',
  `distribu_remark` varchar(255) NOT NULL COMMENT '物流状态描述',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单物流信息表';

CREATE TABLE `order_distribution_number_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `dis_company_id` bigint NOT NULL COMMENT '物流公司ID',
  `dis_company_code` varchar(32) NOT NULL COMMENT '物流公司编码',
  `dis_company_name` varchar(32) NULL COMMENT '物流公司名称',
  `dis_company_number` varchar(32) NOT NULL COMMENT '物流公司物流单号',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单物流单号信息表';

CREATE TABLE `order_goods_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `goods_name` varchar(255) NOT NULL COMMENT '商品名称',
  `goods_cat_id` bigint NOT NULL COMMENT '商品分类ID',
  `goods_cat_code` varchar(32) NOT NULL COMMENT '商品分类编码',
  `goods_cat_name` varchar(64) NULL COMMENT '商品分类名称',
  `goods_brand_id` bigint NOT NULL COMMENT '商品品牌ID',
  `goods_brand_code` varchar(255) NOT NULL COMMENT '商品品牌编码',
  `goods_brand_name` varchar(255) NULL COMMENT '商品品牌名称',
  `ori_amount` bigint NOT NULL COMMENT '商品原价',
  `sale_amount` bigint NOT NULL COMMENT '商品售价',
  `sale_num` bigint NOT NULL COMMENT '商品售卖数量',
  `reject_num` bigint NULL COMMENT '商品退货数量',
  `is_send` tinyint(1) NOT NULL COMMENT '是否发货 0否 1是',
  `send_time` bigint NULL COMMENT '发货时间',
  `sign_time` bigint NULL COMMENT '签收时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单商品表-每一笔订单的商品都需要拆分到此表';

CREATE TABLE `order_goods_pay_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `order_goods_id` bigint NOT NULL COMMENT '订单商品表ID',
  `order_pay_id` bigint NOT NULL COMMENT '订单支付表ID',
  `pay_amount` bigint NOT NULL COMMENT '支付拆分金额',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单商品支付拆分表\n支付金额按照一定规则拆分到商品上';

CREATE TABLE `order_goos_coupon_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `order_goods_id` bigint NOT NULL COMMENT '订单商品ID',
  `order_coupon_id` bigint NOT NULL COMMENT '订单优惠ID',
  `pay_amount` bigint NOT NULL COMMENT '订单优惠拆分金额',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单优惠拆分表';

CREATE TABLE `order_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_code` varchar(32) NOT NULL COMMENT '订单号',
  `order_status` tinyint(1) NULL COMMENT '订单状态 默认0新建 1待支付 2待发货 3待收货 4售后 5已取消',
  `channel_id` bigint NOT NULL COMMENT '渠道ID 1线上 2线下 3 支付宝',
  `channel_code` varchar(32) NOT NULL COMMENT '渠道编码',
  `channel_name` varchar(32) NULL COMMENT '渠道名称',
  `is_presell` tinyint(1) NULL COMMENT '是否预售0否1是',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `pay_time` bigint NULL COMMENT '订单支付时间',
  `is_send` tinyint(1) NULL COMMENT '是否已发货 0否1是 2部分发货',
  `send_time` bigint NULL COMMENT '发货时间',
  `sign_time` bigint NULL COMMENT '签收时间',
  `confirm_time` bigint NULL COMMENT '确认收货时间',
  `ori_amount` bigint NULL COMMENT '订单商品原始金额',
  `pay_amount` bigint NULL COMMENT '订单实际需要支付金额',
  `dis_amount` bigint NULL COMMENT '优惠金额',
  `activity_dis_amount` bigint NULL COMMENT '活动优惠金额',
  `voucher_dis_amount` bigint NULL COMMENT '券优惠金额',
  `reject_amount` bigint NULL COMMENT '订单退款金额',
  `reject_status` tinyint(1) NULL COMMENT '订单退货状态 0否 1部分退 2全部退货',
  `reject_time` bigint NULL COMMENT '退货时间',
  `remark` varchar(128) NULL COMMENT '订单备注',
  `is_stage` tinyint(1) NULL DEFAULT 0 COMMENT '是否分期订单0否1是',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单基本信息表';

CREATE TABLE `order_pay_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `is_presell` tinyint(1) NULL COMMENT '是否预售0否1是',
  `pay_amount` bigint NOT NULL COMMENT '支付金额',
  `pay_type_code` varchar(32) NOT NULL COMMENT '支付类型编码',
  `pay_type_name` varchar(32) NOT NULL COMMENT '支付类型名称',
  `third_pay_number` varchar(32) NOT NULL COMMENT '三方支付号',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单支付信息表';

CREATE TABLE `order_receive_address_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `user_receive_address_id` bigint NOT NULL COMMENT '用户收货地址ID',
  `is_delete` tinyint(1) NOT NULL AUTO_INCREMENT COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单收货地址关联表';

CREATE TABLE `order_voucher_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `merchant_id` bigint NOT NULL COMMENT '商户ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `order_pay_id` bigint NOT NULL COMMENT '订单支付ID',
  `voucher_code` varchar(32) NOT NULL COMMENT '优惠券编码',
  `voucher_name` varchar(255) NULL COMMENT '优惠券名称',
  `voucher_type` tinyint(1) NOT NULL COMMENT '优惠券类型 1代金券 2定额券 3兑换券',
  `voucher_amount` bigint NOT NULL COMMENT '优惠券面值',
  `voucher_use_amount` bigint NOT NULL COMMENT '优惠券抵用面值',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '订单优惠券表';

CREATE TABLE `user_base_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `user_name` varchar(64) NOT NULL COMMENT '用户姓名',
  `nick_name` varchar(255) NULL COMMENT '昵称',
  `mobile` varchar(32) NOT NULL COMMENT '用户手机号',
  `email` varchar(32) NULL COMMENT '邮箱',
  `user_birth` bigint NULL COMMENT '生日-时间戳存储',
  `iden_type` int NULL COMMENT '身份类型 1身份证 2护照',
  `iden_number` varchar(32) NULL COMMENT '身份编号',
  `pass_word` varchar(255) NOT NULL COMMENT '密码',
  `sex` tinyint(1) NOT NULL COMMENT '性别 1男 2女',
  `is_real` tinyint(1) NULL COMMENT '是否实名0否 1是',
  `head_img_url` varchar(255) NULL COMMENT '头像图片地址',
  `limited` tinyint(1) NULL COMMENT '是否被限制登录 0否 1是',
  `logout_time` bigint NULL COMMENT '注销日期',
  `is_forb` tinyint(1) NULL COMMENT '是否账户禁用 0否 1是',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除 0否1是',
  `gmt_create` bigint NULL COMMENT '创建时间',
  `is_without_pay` tinyint(1) NULL DEFAULT 0 COMMENT '是否免密支付0否1是',
  PRIMARY KEY (`id`)
) COMMENT = '用户基础信息表';

CREATE TABLE `user_belong_country`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NULL COMMENT '租户ID',
  `user_id` bigint NULL COMMENT '用户ID',
  `belong_area_id` bigint NULL COMMENT '用户所属国家/地区ID',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '用户所属国家/地区表';

CREATE TABLE `user_receive_address_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NOT NULL COMMENT '租户ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `receive_name` varchar(32) NOT NULL COMMENT '收货人姓名',
  `receive_mobile` varchar(32) NOT NULL COMMENT '收货人手机号',
  `receive_country` varchar(255) NULL COMMENT '收货人国家',
  `receive_first_part` varchar(255) NOT NULL COMMENT '收货人一级地区',
  `receive_second_part` varchar(255) NOT NULL COMMENT '收货人二级地区',
  `receive_third_part` varchar(255) NULL COMMENT '收货人三级地区',
  `receive_address` varchar(255) NULL COMMENT '详细地址',
  `receive_label` varchar(32) NULL COMMENT '收货地址标签',
  `post_code` varchar(64) NOT NULL COMMENT '收货地址邮编',
  `is_default` tinyint(1) NULL DEFAULT 0 COMMENT '是否为默认收货地址 0否 1是',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '用户收件地址表';

CREATE TABLE `user_third_login_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint NULL COMMENT '租户ID',
  `user_id` bigint NULL COMMENT '用户ID',
  `third_type` int NULL COMMENT '三方类型',
  `third_name` varchar(32) NULL COMMENT '三方名称',
  `third_login_token` varchar(255) NULL COMMENT '三方登录凭证',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '用户三方登录关联信息表';

CREATE TABLE `user_third_pay_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint NULL COMMENT '用户ID',
  `third_pay_type` tinyint NULL COMMENT '三方支付类型',
  `third_pay_name` varchar(64) NULL COMMENT '三方支付名称',
  `third_bind_pay_token` varchar(255) NULL COMMENT '三方绑定支付凭证',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除0否1是',
  `gmt_create` bigint NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT = '用户三方授权支付信息';

