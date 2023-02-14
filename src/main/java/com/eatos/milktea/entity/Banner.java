package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "banner")
public class Banner implements Serializable {
    @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid; // 'id',
    private String title;// '标题',
    private String content;// '描述内容',
    private String icon; //'图片',
    private String url; //'链接地址',
}
