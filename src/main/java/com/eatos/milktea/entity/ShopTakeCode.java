package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "shop_takecode")
public class ShopTakeCode {
    @TableId(value = "tid",type = IdType.AUTO)
    private Integer tid;//'id',
    private Integer sid;//'门店id',
    private String today;//'日期',
    private Integer takecode;// '聚餐号码',
}
