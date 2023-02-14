package com.eatos.milktea.web;

import com.eatos.milktea.entity.vo.CategoryVo;
import com.eatos.milktea.entity.vo.MyResult;
import com.eatos.milktea.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getlist")
    public MyResult getList(){
        MyResult myResult = new MyResult();
        try{
            List<CategoryVo> list = categoryService.getCategoryGoodsList();
            if(list!=null && list.size()>0){
                myResult.setStatusCode(200);
                myResult.setMessage("success");
                myResult.setMydata(list);
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
