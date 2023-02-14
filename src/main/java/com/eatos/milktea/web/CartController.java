package com.eatos.milktea.web;

import com.eatos.milktea.entity.Cart;
import com.eatos.milktea.entity.vo.MyResult;
import com.eatos.milktea.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 更新购物车的数据
     * @param cart
     * @return
     */
    @RequestMapping("/updatecart")
    public MyResult updateCart(@RequestBody Cart cart){
        MyResult myResult = new MyResult();
        try{
            cartService.updateCart(cart);
            myResult.setStatusCode(200);
            myResult.setMessage("已成功更新购物车");
            myResult.setMydata(cart);
        }catch (Exception ex){
            myResult.setStatusCode(500);
            myResult.setMessage("更新购物车失败");
        }
        return myResult;
    }

    /**
     * 删除购物车
     * @param cartid
     * @return
     */
    @RequestMapping("/delcart/{cartid}")
    public MyResult delcart(@PathVariable(value = "cartid") Long cartid){
        MyResult myResult = new MyResult();
        try{
           int rows = cartService.delcart(cartid);
           if(rows>0){
               myResult.setStatusCode(200);
               myResult.setMessage("已成功更新购物车");
               myResult.setMydata(rows);
           }
           else{
               myResult.setStatusCode(203);
               myResult.setMessage("删除购物车失败");
               myResult.setMydata(0);
           }
        }catch (Exception ex){
            myResult.setStatusCode(500);
            myResult.setMessage("删除购物车失败");
        }
        return myResult;
    }

    /**
     * 获得购物车数据
     * @param cid 客户的id
     * @param sid 门店的id
     * @return
     */
    @RequestMapping("/getcart/{cid}/{sid}")
    public MyResult getCart(@PathVariable(value = "cid") Long cid,@PathVariable(value = "sid") Integer sid){
        MyResult myResult = new MyResult();
        try{
            Cart cart = cartService.getCart(cid, sid);
            if(cart!=null){
                myResult.setStatusCode(200);
                myResult.setMessage("已成功查询购物车数据");
                myResult.setMydata(cart);
            }
            else{
                myResult.setStatusCode(404);
                myResult.setMessage("没有查询到购物车数据");
                myResult.setMydata(null);
            }
        }catch (Exception ex){
            myResult.setStatusCode(500);
            myResult.setMessage("查询购物车失败");
        }
        return myResult;
    }
}
