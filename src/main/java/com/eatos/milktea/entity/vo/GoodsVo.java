package com.eatos.milktea.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsVo implements Serializable {
    private Integer gid;//'商品id',
    private String gname;//'商品名称',
    private String content;//'商品内容',
    private String icon;//'商品图片',
    private Integer price;//'商品价格（无杯型）',
    // 一个商品对应多个杯型
    private List<BSizeVo> bsize;//杯型
    // 一个商品对应多个加料
    private List<JiaLiaoVo> jialiao;//加料
    private String[] diliao;//底料
    private String[] diliao2;//底料
    private String[] wendu;//温度
    private String[] tangdu;//糖度
}
