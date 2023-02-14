package com.eatos.milktea.entity.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class JiaLiaoVo implements Serializable {
    private Integer lid;//id
    private String lname;//加料名称
    private Integer lprice;//加料价格
    private int lnum=0;//加料量
}
