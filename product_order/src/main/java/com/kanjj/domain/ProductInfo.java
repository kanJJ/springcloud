package com.kanjj.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Chris on 2018/9/19.
 */
@Data
@Entity
public class ProductInfo {

    @Id
    private String productId;

    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
    private Integer productStatus;
    private Date createTime;
    private Date updateTime;

}
