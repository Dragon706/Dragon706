package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 * 购物车详细表
 */
@Data
@TableName(value = "cart_detail")
public class CartDetail implements Serializable {
    @TableId(value = "cdid", type = IdType.AUTO)
    private Long cdid;//'购物车详细id',
    private Integer gid;//'商品id',
    private String gname;//'商品名称'
    private String icon;//'商品图片'
    private String bcontent;//'商品内容'
    private Integer buyPrice;//'商品价格',
    private Integer buyNums;//'商品数量',
    private Long cartid;//'购物车id',
}
