package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "shops")
public class Shops implements Serializable {
    @TableId(value = "sid",type = IdType.AUTO)
    private Integer sid;//id,
    private String sname;//'门店名称',
    private String province;//'所在省市区（县）',
    private String saddress;// '详细地址',
    private String onlineStartTime;//'每天开始营业时间',
    private String onlineEndTime;//'每天结束营业时间',
    private Double longitude;//'经度',
    private Double latitude;//'纬度',
    private Integer takeout;//'1.需自提 2.可外送',
    private String phone;//'电话',
    private Integer sstatus;//'状态：1正常 2.休息 3.繁忙置休',
    @TableField(exist = false)
    private String takeoutStr;//1.需自提 2.可外送

    public String getTakeoutStr() {
        if (this.takeout==1)
            return "需自提";
        else
            return "可外送";
    }
}
