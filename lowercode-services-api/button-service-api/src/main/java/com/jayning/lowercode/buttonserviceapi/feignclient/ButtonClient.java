package com.jayning.lowercode.buttonserviceapi.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * desc:
 * createBy: Ningjianjian
 */
@FeignClient(name = "button-service")
public interface ButtonClient {

    @GetMapping("getButton")
    String getButton();
}
