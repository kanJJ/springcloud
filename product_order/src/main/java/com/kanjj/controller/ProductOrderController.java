package com.kanjj.controller;

import com.kanjj.domain.ProductInfo;
import com.kanjj.domain.ResultVo;
import com.kanjj.feign.Product;
import com.kanjj.vo.ProductCategoryVo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;

/**
 * Created by Chris on 2018/9/26.
 */
@RestController
@RequestMapping("productOrder")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ProductOrderController {

    @Autowired
    private Product product;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("orderList")
    public ResultVo<List<ProductInfo>> orderList() {
        ResultVo<List<ProductInfo>> listResultVo = product.listOrder(Arrays.asList("111111111111111111"));
        return listResultVo;
    }
    // 超时配置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
//    })
    @HystrixCommand(
            // fallbackMethod = "fallback",
            commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled", value="true"),    //开启熔断设置
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),   //  number of requests that must be made within a statisticalWindow before open/close decisions are made using stats
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"),   // 熔断时间
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60")  // 超过60% 请求失败, 将会进入熔断状态
    })
    @GetMapping("hello")
    public String getProductList(){
        RestTemplate restTemplate = new RestTemplate();
        String hello = restTemplate.getForObject("http://localhost:8081/env/hello", String.class);
        return hello;
    }

    public String fallback() {
        return "hystric feedback";
    }

    public String defaultFallback() {
        return "default hystrix fallback";
    }

}
