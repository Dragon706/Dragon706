package com.eatos.milktea.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eatos.milktea.entity.Shops;
import com.eatos.milktea.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopsService {
    @Autowired
    private ShopMapper shopMapper;

    /**
     * 查询所有门店列表
     * @return
     */
    public List<Shops> findAll(){
        return shopMapper.selectList(null);
    }

    /**
     * 通过城市city查询门店列表
     * @param city
     * @return
     */
    public List<Shops> findByCity(String city){
        if(city==null || "".equals(city)){
            return shopMapper.selectList(null);
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("province",city);
        return shopMapper.selectList(queryWrapper);
    }
    /**
     * 根据门店sid，获得门店信息
     * @param sid
     * @return
     */
    public Shops findById(Integer sid){
        return shopMapper.selectById(sid);
    }
}
