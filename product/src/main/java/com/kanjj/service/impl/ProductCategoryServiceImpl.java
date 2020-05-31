package com.kanjj.service.impl;

import com.kanjj.dao.ProductCategoryRepository;
import com.kanjj.domain.ProductCategory;
import com.kanjj.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chris on 2018/9/20.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryType(categoryTypeList);
    }
}
