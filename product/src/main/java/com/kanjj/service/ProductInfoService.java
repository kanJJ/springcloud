package com.kanjj.service;

import com.kanjj.domain.ProductInfo;

import java.util.List;

/**
 * Created by Chris on 2018/9/20.
 */
public interface ProductInfoService {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductId (List<String> productIdList);
}
