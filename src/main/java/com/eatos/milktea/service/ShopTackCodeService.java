package com.eatos.milktea.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eatos.milktea.entity.ShopTakeCode;
import com.eatos.milktea.mapper.ShopTakeCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShopTackCodeService {
    @Autowired
    private ShopTakeCodeMapper shopTakeCodeMapper;

    /**
     * 获得对应门店的取餐号
     * @param sid 门店id
     * @return
     */
    public Integer getShopTackCode(Integer sid){
        String toDay = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        QueryWrapper queryWrapper1 = new QueryWrapper();
        Map<String, Object> queryParamsMap = new HashMap<>();
        queryParamsMap.put("sid",sid);
        queryParamsMap.put("today", toDay);
        queryWrapper1.allEq(queryParamsMap);
        ShopTakeCode shopTackCode = shopTakeCodeMapper.selectOne(queryWrapper1);

        if(shopTackCode==null){//没有获得取餐号码，插入新的记录
            shopTackCode = new ShopTakeCode();
            shopTackCode.setSid(sid);
            shopTackCode.setToday(toDay);
            shopTackCode.setTakecode(1000);
            shopTakeCodeMapper.insert(shopTackCode);
            return shopTackCode.getTakecode();
        }
        else{
            shopTackCode.setTakecode(shopTackCode.getTakecode()+1);
            shopTakeCodeMapper.updateById(shopTackCode);
            return shopTackCode.getTakecode();
        }
    }
}
