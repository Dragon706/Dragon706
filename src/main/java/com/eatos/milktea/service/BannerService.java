package com.eatos.milktea.service;

import com.eatos.milktea.entity.Banner;
import com.eatos.milktea.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    /*
    * 返回广告列表
    * @return*/
    public List<Banner> getBannerList(){
        return bannerMapper.selectList(null);
    }
}
