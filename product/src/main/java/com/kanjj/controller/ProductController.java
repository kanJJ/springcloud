package com.kanjj.controller;

import com.kanjj.domain.ProductCategory;
import com.kanjj.domain.ProductInfo;
import com.kanjj.enums.ProductEnum;
import com.kanjj.service.ProductCategoryService;
import com.kanjj.service.ProductInfoService;
import com.kanjj.vo.ProductCategoryVo;
import com.kanjj.vo.ProductInfoVo;
import com.kanjj.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chris on 2018/9/21.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVo<List<ProductCategoryVo>> list() {
        //获取所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findByProductStatus(ProductEnum.UP.getType());

        List<Integer> categoryStatusList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = productCategoryService.findByCategoryType(categoryStatusList);

        List<ProductCategoryVo> productCategoryVoList = new ArrayList<>();
        for (ProductCategory category: categoryList) {

            ProductCategoryVo productCategoryVo = new ProductCategoryVo();
            productCategoryVo.setCategoryName(category.getCategoryName());
            productCategoryVo.setCategoryType(category.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo product: productInfoList) {
                if (category.getCategoryType().equals(product.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(product, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productCategoryVo.setFoods(productInfoVoList);
            productCategoryVoList.add(productCategoryVo);
        }
        ResultVo<List<ProductCategoryVo>> resultVo = new ResultVo<>();
        resultVo.setData(productCategoryVoList);
        resultVo.setResultCode("0");
        resultVo.setResultMsg("成功");
        return resultVo;
    }

    @PostMapping("listOrder")
    public ResultVo<List<ProductInfo>> listOrder(@RequestBody List<String> list) {
        List<ProductInfo> byProductId = productInfoService.findByProductId(list);
        ResultVo<List<ProductInfo>> listResultVo = new ResultVo<>();
        listResultVo.setData(byProductId);
        listResultVo.setResultMsg("成功");
        listResultVo.setResultCode("200");
        return listResultVo;
    }


}
