package com.kanjj.enums;

import lombok.Getter;

/**
 * Created by Chris on 2018/9/20.
 */
@Getter
public enum  ProductEnum {
    UP(0,"上架"),
    DOWN(1, "下架"),
    ;

    private Integer type;
    private String code;

    ProductEnum(Integer type, String code) {
        this.type = type;
        this.code = code;
    }
}
