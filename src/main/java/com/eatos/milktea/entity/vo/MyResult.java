package com.eatos.milktea.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyResult implements Serializable {
    private Integer statusCode=200;
    private String message;
    private  Object mydata;
}
