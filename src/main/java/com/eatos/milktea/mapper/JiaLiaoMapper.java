package com.eatos.milktea.mapper;

import com.eatos.milktea.entity.vo.JiaLiaoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JiaLiaoMapper{
    @Select("SELECT * FROM jialiao where lid in (SELECT lid from goods_jialiao where gid=#{gid})")
    public List<JiaLiaoVo> getJiaLiaoByGid(@Param(value = "gid") Integer gid);
}
