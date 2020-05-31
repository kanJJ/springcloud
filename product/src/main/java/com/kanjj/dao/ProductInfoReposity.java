package com.kanjj.dao;

import com.kanjj.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Chris on 2018/9/19.
 */
public interface ProductInfoReposity extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus (Integer productStatus);

    @Query(value = "select a.* from product_info a where a.product_id in ?1 and a.product_status = 0",nativeQuery=true)
    List<ProductInfo> findByProductId (List<String> productIdList);
}
