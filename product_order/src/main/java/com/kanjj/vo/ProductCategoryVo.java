package com.kanjj.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Chris on 2018/9/21.
 */
@Data
public class ProductCategoryVo {

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;

    private List<ProductInfoVo> foods;

}
