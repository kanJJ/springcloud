package com.kanjj.dao;

import com.kanjj.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Chris on 2018/9/20.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryType(List<Integer> categoryTypeList);
}
