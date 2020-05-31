package com.kanjj.feign;

import com.kanjj.domain.ProductInfo;
import com.kanjj.domain.ResultVo;
import com.kanjj.vo.ProductCategoryVo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Chris on 2018/11/4.
 */
@Component
public class ProductFallback implements  Product {
    @Override
    public ResultVo<List<ProductInfo>> listOrder(@RequestBody List<String> list) {
        return null;
    }

    @Override
    public ResultVo<List<ProductCategoryVo>> list() {
        return null;
    }
}
