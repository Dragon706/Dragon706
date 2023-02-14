package com.eatos.milktea.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eatos.milktea.entity.Orders;
import com.eatos.milktea.entity.OrdersDetail;
import com.eatos.milktea.mapper.OrderDetailMapper;
import com.eatos.milktea.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailMapper ordersDetailMapper;
    @Autowired
    private ShopsService shopsService;

    /**
     * 添加订单
     * @param orders
     * @return
     */
    @Transactional
    public int addOrders(Orders orders){
        // 添加订单主表
        int rows = ordersMapper.insert(orders);
        // 添加订单从表
        for (OrdersDetail od:orders.getGoods()) {
            od.setOrderid(orders.getOrderid());
            rows+=ordersDetailMapper.insert(od);
        }

        return rows;
    }

    /**
     * 更新订单
     * @param orders
     * @return
     */
    @Transactional
    public int updateOrders(Orders orders){
        // 更新订单主表
        int rows = ordersMapper.updateById(orders);
        return rows;
        }

    /**
     * 根据订单orderid，获得订单
     * @param orderid
     * @return
     */
    public Orders findById(String orderid){
        // 先查询购物车主表
        Orders  orders= ordersMapper.selectById(orderid);

        if(orders!=null){
            // 查询购物车详细表
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("orderid", orders.getOrderid());
                List<OrdersDetail> ordersDetailList = ordersDetailMapper.selectList(queryWrapper);
                orders.setGoods(ordersDetailList);

                // 查询门店信息
                orders.setShop(shopsService.findById(orders.getSid()));
        }

        return orders;
    }
    /**
     * 根据用户及订单状态获得订单列表
     * @param cid
     * //@param orderstatus;//'订单状态： 0.待支付 1.已支付 2.制作中 3.已完成 4.已取消 5.退单',
     * @return
     */
    public List<Orders> getOrdersList(Long cid){
        // 先查询购物车主表
        QueryWrapper queryWrapper1 = new QueryWrapper();
        Map<String, Object> queryParamsMap = new HashMap<>();
        queryParamsMap.put("cid",cid);
        queryWrapper1.allEq(queryParamsMap);
        List<Orders> ordersList = ordersMapper.selectList(queryWrapper1);

        if(ordersList!=null && ordersList.size()>0){
            // 查询购物车详细表
            for (Orders orders:ordersList) {
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("orderid", orders.getOrderid());
                List<OrdersDetail> ordersDetailList = ordersDetailMapper.selectList(queryWrapper);
                orders.setGoods(ordersDetailList);

                // 查询门店信息
                orders.setShop(shopsService.findById(orders.getSid()));
            }
        }

        return ordersList;
    }
}
