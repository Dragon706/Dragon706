package com.eatos.milktea.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName(value = "category")
public class CategoryVo implements Serializable {
    @TableId(value = "cgid",type = IdType.AUTO)
    private Integer cgid;//'类别id',
    private String cgname;//'类别名称',
    private String cgicon;//'类别图片',
    private Integer cgstatus;//'类别状态: 1正常 2.下线'
    private Integer position;//排序位置
    // 一个类别有多个商品
    @TableField(exist = false)
    private List<GoodsVo> goods; //商品列表
}
