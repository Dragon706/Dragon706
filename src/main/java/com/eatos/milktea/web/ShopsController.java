package com.eatos.milktea.web;

import com.eatos.milktea.entity.Shops;
import com.eatos.milktea.entity.vo.MyResult;
import com.eatos.milktea.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shops")
@CrossOrigin
public class ShopsController {
    @Autowired
    private ShopsService shopsService;

    @RequestMapping("/findall")
    public MyResult findAll(){
        MyResult myResult = new MyResult();
        try {
            List<Shops> shopslist = shopsService.findAll();
            if (shopslist!=null && shopslist.size()>0){
            myResult.setStatusCode(200);
            myResult.setMessage("已经成功查询到门店列表");
            myResult.setMydata(shopslist);
        }
            else{
                myResult.setStatusCode(404);
                myResult.setMessage("没有查询到门店列表");
                myResult.setMydata(null);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            myResult.setStatusCode(500);
            myResult.setMessage("查询到门店列表出错");
            myResult.setMydata(null);
        }
        return myResult;
    }

    @RequestMapping({"/findbycity/{city}","/findbycity"})
    public MyResult findByCity(@PathVariable(name = "city",required = false) String city) {
        MyResult myResult = new MyResult();
        try{
            List<Shops> shopslist = shopsService.findByCity(city);
            if(shopslist.size()>0){
                myResult.setStatusCode(200);
                myResult.setMessage("已成功查询门店列表");
                myResult.setMydata(shopslist);
            }
            else{
                myResult.setStatusCode(404);
                myResult.setMessage("没有查询到门店列表");
                myResult.setMydata(null);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            myResult.setStatusCode(500);
            myResult.setMessage("查询到门店列表出错");
            myResult.setMydata(null);
        }
        return myResult;
    }
}