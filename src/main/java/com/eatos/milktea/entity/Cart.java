package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName(value = "cart")
public class Cart implements Serializable {
    @TableId(value = "cartid", type = IdType.AUTO)
    private Long cartid;//购物车
    private Long cid;//客户
    private Integer sid;//门店
    private Integer buyTotalNums;//购买总数量
    private Integer allPrice; //购习总价格
    private String beizhu;  //备注
    @TableField(exist = false)
    private List<CartDetail> goods;//购买的商品列表

}
