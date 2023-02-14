package com.eatos.milktea.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eatos.milktea.entity.Goods;
import com.eatos.milktea.entity.vo.BSizeVo;
import com.eatos.milktea.entity.vo.CategoryVo;
import com.eatos.milktea.entity.vo.GoodsVo;
import com.eatos.milktea.entity.vo.JiaLiaoVo;
import com.eatos.milktea.mapper.CategoryMapper;
import com.eatos.milktea.mapper.GoodsMapper;
import com.eatos.milktea.mapper.JiaLiaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private JiaLiaoMapper jiaLiaoMapper;

    /**
     * 返回所有类别下的所有商品列表
     * @return
     */
    public List<CategoryVo> getCategoryGoodsList(){
        /**
         * 实现思路
         * 1.查询所有商品类别
         * 2.查询所在类别商品信息
         * 3.当前商品的杯型
         * 4.当前商品的加料数据
         * 5.当前商品的底料
         * 6.当前商品的温度
         * 7.当前商品的糖度
         * 8.返回封装数据
         */
        //1.查询所有商品类别
        List<CategoryVo> categoryList = categoryMapper.selectList(null);
//        System.out.println(categoryList);
        for (CategoryVo categoryVo:categoryList) {
            List<Goods> goodsList = new ArrayList<>();
            // 如果是新商品类别
            if (categoryVo.getCgid()==1){
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("isNew",1);
                goodsList = goodsMapper.selectList(queryWrapper);
            }
            else {
                // 2.查询所在类别商品信息
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("cgid",categoryVo.getCgid());
                goodsList = goodsMapper.selectList(queryWrapper);
            }
            List<GoodsVo> goodsVoList = new ArrayList<>();
            // 2.1 把goodsList集中的数据封装到goodsVoList
            for(Goods goods:goodsList){
                // 2.2 创建GoodsVo对象，做数据封装
                GoodsVo goodsVo = new GoodsVo();
                goodsVo.setGid(goods.getGid());// 商品id
                goodsVo.setGname(goods.getGname());//'商品名称',
                goodsVo.setContent(goods.getContent());//'商品内容',
                goodsVo.setIcon(goods.getIcon());//'商品图片',
                goodsVo.setPrice(goods.getPrice());//'商品价格（无杯型）',
                // 3.当前商品的杯型
                // 一个商品对应多个杯型
                if(goods.getMinPrice()>0 || goods.getMidPrice()>0 || goods.getMaxPrice()>0){
                    List<BSizeVo> bsizeList = new ArrayList<>();
                    // 小杯
                    if(goods.getMinPrice()>0){
                        BSizeVo bSizeVo = new BSizeVo();
                        bSizeVo.setBxing("小杯");
                        bSizeVo.setBprice(goods.getMinPrice());
                        bsizeList.add(bSizeVo);
                    }
                    // 中杯
                    if(goods.getMidPrice()>0){
                        BSizeVo bSizeVo = new BSizeVo();
                        bSizeVo.setBxing("中杯");
                        bSizeVo.setBprice(goods.getMidPrice());
                        bsizeList.add(bSizeVo);
                    }
                    // 大杯
                    if(goods.getMaxPrice()>0){
                        BSizeVo bSizeVo = new BSizeVo();
                        bSizeVo.setBxing("大杯");
                        bSizeVo.setBprice(goods.getMaxPrice());
                        bsizeList.add(bSizeVo);
                    }
                    goodsVo.setBsize(bsizeList);
                }
                else {
                    goodsVo.setBsize(new ArrayList<>(0));
                }
                //4.当前商品的加料数据
                // 一个商品对应多个加料
                List<JiaLiaoVo> jiaLiaoList = jiaLiaoMapper.getJiaLiaoByGid(goods.getGid());
                if(jiaLiaoList!=null && jiaLiaoList.size()>0){
                    goodsVo.setJialiao(jiaLiaoList);
                }
                else{
                    goodsVo.setJialiao(new ArrayList<>(0));
                }
                //5.当前商品的底料
                //底料
                if(!"".equals(goods.getDiliao()) && goods.getDiliao()!=null){
                    goodsVo.setDiliao(goods.getDiliao().split(","));
                }
                else{
                    goodsVo.setDiliao(new String[]{});
                }
                //底料2
                if(!"".equals(goods.getDiliao2()) && goods.getDiliao2()!=null){
                    goodsVo.setDiliao2(goods.getDiliao2().split(","));
                }
                else{
                    goodsVo.setDiliao2(new String[]{});
                }
                //6.当前商品的温度
                //温度
                if(!"".equals(goods.getWendu()) && goods.getWendu()!=null){
                    goodsVo.setWendu(goods.getWendu().split(","));
                }
                else{
                    goodsVo.setWendu(new String[]{});
                }
                //7.当前商品的糖度
                //糖度
                if(!"".equals(goods.getTangdu()) && goods.getTangdu()!=null){
                    goodsVo.setTangdu(goods.getTangdu().split(","));
                }
                else{
                    goodsVo.setTangdu(new String[]{});
                }
                goodsVoList.add(goodsVo);
            }
            categoryVo.setGoods(goodsVoList);
        }

        return categoryList;
    }
}
