package com.kanjj.service.impl;

import com.kanjj.dao.ProductInfoReposity;
import com.kanjj.domain.ProductInfo;
import com.kanjj.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chris on 2018/9/20.
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoReposity productInfoReposity;

    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return productInfoReposity.findByProductStatus(productStatus);
    }

    @Override
    public List<ProductInfo> findByProductId(List<String> productIdList) {
        return productInfoReposity.findByProductId(productIdList);
    }
}
