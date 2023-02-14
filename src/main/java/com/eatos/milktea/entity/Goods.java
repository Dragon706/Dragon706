package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 *商品表
 */
@Data
@TableName(value = "goods")
public class Goods implements Serializable {
    @TableId(value = "gid",type = IdType.AUTO)
    private Integer gid;//'商品id',
    private String gname;//'商品名称',
    private String content;//'商品内容',
    private String icon;//'商品图片',
    private Integer price;//'商品价格（无杯型）',
    private Integer minPrice;//'小杯型价格： 0.无效',
    private Integer midPrice;//'中杯型价格： 0.无效',
    private Integer maxPrice;//'大杯型价格： 0.无效',
    private String diliao;//底料
    private String diliao2;//底料
    private String wendu;//温度
    private String tangdu;//糖度
    private Integer gstatus;//'商品状态：0,下架  1,上架',
    private Integer cgid;//'商品类型',
}
