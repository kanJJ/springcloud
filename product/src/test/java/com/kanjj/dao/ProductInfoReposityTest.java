package com.kanjj.dao;

import com.kanjj.domain.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Chris on 2018/9/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoReposityTest {

    @Autowired
    private ProductInfoReposity productInfoReposity;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> byProductStatus = productInfoReposity.findByProductStatus(0);
        System.out.println(byProductStatus);
    }

    @Test
    public void findByProductId() throws Exception {
        List<ProductInfo> byProductStatus = productInfoReposity.findByProductId(Arrays.asList("111111111111111111"));
        System.out.println(byProductStatus);
    }

}