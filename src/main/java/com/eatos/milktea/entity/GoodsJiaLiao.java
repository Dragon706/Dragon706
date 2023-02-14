package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "goods_jialiao")
public class GoodsJiaLiao implements Serializable {
    private Integer gid;//'商品id',
    private Integer lid;//'加料id'
}
