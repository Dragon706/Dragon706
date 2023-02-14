package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "orders_detail")
public class OrdersDetail implements Serializable {
    @TableId(value = "odid",type = IdType.AUTO)
    private Long odid;//'订单详细id',
    private Integer gid;//'商品id',
    private String gname;//'商品名称'
    private String icon;//'商品图片'
    private String bcontent;//'商品内容'
    private Integer buyPrice;//'购买价格',
    private Integer buyNums;//'购买数量',
    private String orderid;//'订单id',
}
