package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 * 商品加料表
 */
@Data
@TableName(value = "jialiao")
public class JiaLiao implements Serializable {
    @TableId(value = "lid",type = IdType.AUTO)
    private Integer lid;//'加料id',
    private String lname;//'加料名称',
    private Integer lprice;//'加料价格',
}
