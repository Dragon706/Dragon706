package com.eatos.milktea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eatos.milktea.entity.OrdersDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrdersDetail> {
}
