package com.eatos.milktea.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eatos.milktea.entity.Cart;
import com.eatos.milktea.entity.CartDetail;
import com.eatos.milktea.mapper.CartDetailMapper;
import com.eatos.milktea.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartDetailMapper cartDetailMapper;
    /*
    * 更新购物车的数据
    * @param cart
    * @return
    * */
    @Transactional
    public Cart updateCart(Cart cart){
        if (cart.getCartid()!=null && cart.getCartid()>0){//更新购物车
            //先删除购物车详细表的数据
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("cartid",cart.getCartid());
            cartDetailMapper.delete(queryWrapper);
            cartMapper.updateById(cart);
        }
        else {//添加购物车
            cartMapper.insert(cart);
        }
        //向购物车从表添加数据
        for (CartDetail cartDetail:cart.getGoods()){
            cartDetail.setCartid(cart.getCartid());
            cartDetailMapper.insert(cartDetail);
        }
        return cart;
    }
    /*
    * 删除购物车
    * @param cartid
    * @return
    * */
    @Transactional
    public int delcart(Long cartid){
        //1、先删除购物车从表的数据
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("cartid",cartid);
        int rows = cartDetailMapper.delete(queryWrapper);
        //2、再删除购物车主表的数据
        rows+= cartMapper.deleteById(cartid);
        return rows;
    }
    /*
    * 获得购物车中的数据
    * @param cid 客户的id
    * @param sid 门店的id
    * @return
    * */
    public Cart getCart(Long cid,Integer sid){
        //先查询购物车主表
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("cid",cid);
        queryMap.put("sid",sid);
        queryWrapper.allEq(queryMap);
        Cart cart = cartMapper.selectOne(queryWrapper);
        // 再查询购物车的从表
        if (cart!=null){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("cartid",cart.getCartid());
            List<CartDetail> list = cartDetailMapper.selectList(queryWrapper1);
            cart.setGoods(list);
        }
        return cart;
    }
}
