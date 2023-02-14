package com.eatos.milktea.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BSizeVo implements Serializable {
    private String bxing; //小杯、中杯、大杯
    private Integer bprice;//杯型价格
}
