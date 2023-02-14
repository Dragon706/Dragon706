package com.eatos.milktea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eatos.milktea.entity.vo.CategoryVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<CategoryVo> {
}
