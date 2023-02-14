package com.eatos.milktea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "customer")
public class Customer implements Serializable {
    @TableId(value = "cid",type = IdType.INPUT)
    private Long cid;// '客户id',
    private String weixinCode;// '微信号',
    private String nickName;// '客户昵称',
    private String custTel; // '客户电话',
    private String snowCoins; // '雪王币数量',
    private Data lastLoginTime;// '最后一次登录的时间',
    private String openid; // '小程序或公众号唯一标识',
    private String unionid; //'用来确定不同应用下用户的唯一性',
}
