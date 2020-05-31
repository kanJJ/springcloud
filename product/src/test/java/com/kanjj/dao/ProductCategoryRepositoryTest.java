package com.kanjj.dao;

import com.kanjj.domain.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Chris on 2018/9/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryType() throws Exception {
        List<ProductCategory> byCategoryType = productCategoryRepository.findByCategoryType(Arrays.asList(11));
        System.out.println(byCategoryType);
    }

}