package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单表
 */
@Data
@TableName(value = "orders")
public class Orders implements Serializable {
    @TableId(value = "orderid", type = IdType.INPUT)
    private String orderid;//'订单id（cid+时间毫秒数）',
    private Long cid;//'客户id',
    private Integer sid;//'门店id',
    private Long cartid;//'购物车id',
    private Date ordertime;//'订单时间',
    private Date paytime;//'支付时间',
    private Date startMakeTime;//'工作人员开始制作奶茶时间',
    private Date completeTime;//'工作人员制作奶茶完成时间',
    private Integer orderstatus;//'订单状态： 0.待支付 1.已支付 2.制作中 3.已完成 4.已取消 5.退单',
    private String orderstatusStr;//'订单状态： 0.待支付 1.已支付 2.制作中 3.已完成 4.已取消 5.退单',
    private Integer buyTotalNums;//'购物数量',
    private Integer allPrice;//'总价格',
    private Integer takeCode;//'聚餐号码',
    private String beizhu;//'备注'
//    购买的商品列表
    @TableField(exist = false)
    private List<OrdersDetail> goods;
    @TableField(exist = false)
    private Shops shop;
}

