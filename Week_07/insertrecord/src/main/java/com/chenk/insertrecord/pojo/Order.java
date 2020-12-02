package com.chenk.insertrecord.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author chenk
 * @create 2020/12/2 11:27
 */
@Data
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "seller_id")
    private String sellerId;
    @Column(name = "goods_snapshot_id")
    private String goodsSnapshotId;
    @Column(name = "address_id")
    private String addressId;
    @Column(name = "num")
    private int num;
    @Column(name = "price_total")
    private BigDecimal priceTotal;
    @Column(name = "pay_type")
    private String payType;
    @Column(name = "pay_price")
    private BigDecimal payPrice;
    @Column(name = "pay_url")
    private String payUrl;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
}
