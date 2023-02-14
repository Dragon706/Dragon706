package com.eatos.milktea.web;

import com.eatos.milktea.entity.vo.MyResult;
import com.eatos.milktea.service.ShopTackCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/takecode")
@CrossOrigin
public class ShopTakeCodeController {
    @Autowired
    private ShopTackCodeService shopTackCodeService;
    /**
     * 获得对应门店的取餐号
     * @param sid 门店id
     * @return
     */
    @RequestMapping("/gettakecode/{sid}")
    public MyResult getShopTackCode(@PathVariable(value = "sid") Integer sid){
        MyResult myResult = new MyResult();
        try {
            int tackCode = shopTackCodeService.getShopTackCode(sid);
            myResult.setStatusCode(200);
            myResult.setMessage("success");
            myResult.setMydata(tackCode);
        }catch (Exception ex){
            System.out.println(ex);
            myResult.setStatusCode(500);
            myResult.setMessage("获得取餐号码出错了");
        }
        return myResult;
    }
}
