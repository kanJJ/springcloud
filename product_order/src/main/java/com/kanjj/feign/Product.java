package com.kanjj.feign;

import com.kanjj.domain.ProductInfo;
import com.kanjj.domain.ResultVo;
import com.kanjj.vo.ProductCategoryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * Created by Chris on 2018/9/26.
 */
@FeignClient(name = "product", fallback = ProductFallback.class)
public interface Product {

    @PostMapping("/product/listOrder")
    public ResultVo<List<ProductInfo>> listOrder(@RequestBody List<String> list);

    @GetMapping("/priduct/list")
    public ResultVo<List<ProductCategoryVo>> list();

}
