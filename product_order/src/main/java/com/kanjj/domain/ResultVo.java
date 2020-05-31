package com.kanjj.domain;

import lombok.Data;

/**
 * Created by Chris on 2018/9/20.
 */
@Data
public class ResultVo<T> {

    private String resultCode;
    private String resultMsg;
    private T data;
}
