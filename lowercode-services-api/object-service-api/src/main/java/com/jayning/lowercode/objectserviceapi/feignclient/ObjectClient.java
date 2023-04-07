package com.jayning.lowercode.objectserviceapi.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * desc:
 * createBy: Ningjianjian
 */
@FeignClient(name="object-service")
public interface ObjectClient {
    @GetMapping("getObject")
    String getObject();

    @GetMapping("object")
    String object();
}
