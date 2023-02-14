package com.eatos.milktea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eatos.milktea.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

@Mapper  //不可以省略
public interface BannerMapper extends BaseMapper<Banner> {
}
