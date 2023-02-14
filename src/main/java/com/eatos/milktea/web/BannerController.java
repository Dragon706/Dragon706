package com.eatos.milktea.web;

import com.eatos.milktea.entity.Banner;
import com.eatos.milktea.entity.vo.MyResult;
import com.eatos.milktea.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/getlist")
    public MyResult getList(){
        MyResult myResult = new MyResult();
        try{
            List<Banner> bannerList = bannerService.getBannerList();
            if(bannerList!=null && bannerList.size()>0){
                myResult.setStatusCode(200);
                myResult.setMessage("success");
                myResult.setMydata(bannerList);
            }
            else{
                myResult.setStatusCode(404);
                myResult.setMessage("没有查询到广告列表");
                myResult.setMydata(null);
            }
        }catch (Exception ex){
            System.out.println(ex);
            myResult.setStatusCode(500);
            myResult.setMessage("查询广告列表出错了");
        }
        return myResult;
    }
}
