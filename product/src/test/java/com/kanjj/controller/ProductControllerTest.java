package com.kanjj.controller;

import com.kanjj.ProductApplicationTests;
import com.kanjj.domain.ProductInfo;
import com.kanjj.vo.ResultVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Chris on 2018/9/26.
 */
public class ProductControllerTest extends ProductApplicationTests {

    @Autowired
    private ProductController productController;

    @Test
    public void list() throws Exception {

    }

    @Test
    public void listOrder() throws Exception {
        ResultVo<List<ProductInfo>> listResultVo = productController.listOrder(Arrays.asList("111111111111111111"));
        System.out.println(listResultVo);
    }

}