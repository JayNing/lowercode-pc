package com.jayning.lowercode.lowercodeportal.controller;

import com.jayning.lowercode.objectserviceapi.feignclient.ObjectClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * desc:
 * createBy: Ningjianjian
 */
@RestController
public class HystrixController {

    @Resource
    private ObjectClient objectClient;

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"), //熔断窗口持续的时间
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50")
            },fallbackMethod = "fallback"
    )
    @GetMapping("object/{num}")
    public String object(@PathVariable("num") int num){

        if (num % 2 == 0) {
            return "SUCCESS";
        }
        return objectClient.object();
    }

    public String fallback(@PathVariable("num") int num) {
        return "服务降级了";
    }
}
