package com.kanjj.service;

import com.kanjj.domain.ProductCategory;

import java.util.List;

/**
 * Created by Chris on 2018/9/20.
 */
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList);
}
