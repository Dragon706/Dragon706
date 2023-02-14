package com.eatos.milktea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eatos.milktea.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
