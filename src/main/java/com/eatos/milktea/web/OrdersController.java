package com.eatos.milktea.web;

import com.eatos.milktea.entity.Orders;
import com.eatos.milktea.entity.vo.MyResult;
import com.eatos.milktea.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 添加订单
     * @param orders
     * @return
     */
    @RequestMapping("/addorders")
    public MyResult addOrders(@RequestBody Orders orders){
        MyResult myResult = new MyResult();
        try {
            int rows = ordersService.addOrders(orders);
            if(rows>=2){
                myResult.setStatusCode(200);
                myResult.setMessage("success");
                myResult.setMydata(rows);
            }
            else{
                myResult.setStatusCode(300);
                myResult.setMessage("添加订单失败");
            }
        }catch (Exception ex){
            myResult.setStatusCode(500);
            myResult.setMessage("fail");
        }
        return myResult;
    }
    /**
     * 更新订单
     * @param orders
     * @return
     */
    @RequestMapping("/updateorders")
    public MyResult updateOrders(@RequestBody Orders orders){
        MyResult myResult = new MyResult();
        try {
            int rows = ordersService.updateOrders(orders);
            if(rows>=2){
                myResult.setStatusCode(200);
                myResult.setMessage("success");
                myResult.setMydata(rows);
            }
            else{
                myResult.setStatusCode(300);
                myResult.setMessage("更新订单失败");
            }
        }catch (Exception ex){
            myResult.setStatusCode(500);
            myResult.setMessage("fail");
        }
        return myResult;
    }

    /**
     * 根据订单orderid，获得订单
     * @param orderid
     * @return
     */
    @RequestMapping("/findById/{orderid}")
    public MyResult findById(@PathVariable(value = "orderid") String orderid){
        MyResult myResult = new MyResult();
        try {
            Orders orders = ordersService.findById(orderid);
            if(orders!=null){
                myResult.setStatusCode(200);
                myResult.setMessage("success");
                myResult.setMydata(orders);
            }
            else{
                myResult.setStatusCode(404);
                myResult.setMessage("查找订单失败");
            }
        }catch (Exception ex){
            myResult.setStatusCode(500);
            myResult.setMessage("fail");
        }
        return myResult;
    }
    /**
     * 根据用户及订单状态获得订单列表
     * @param cid
     * @return
     */
    @RequestMapping("/getorderslist/{cid}")
    public MyResult getOrdersList(@PathVariable(value = "cid") Long cid){
        MyResult myResult = new MyResult();
        try {
            List<Orders> ordersList= ordersService.getOrdersList(cid);

            if(ordersList!=null && ordersList.size()>0){
                myResult.setStatusCode(200);
                myResult.setMessage("success");
                myResult.setMydata(ordersList);
            }
            else{
                myResult.setStatusCode(404);
                myResult.setMessage("查找订单失败");
            }
        }catch (Exception ex){
            myResult.setStatusCode(500);
            myResult.setMessage("fail");
        }
        return myResult;
    }
}
