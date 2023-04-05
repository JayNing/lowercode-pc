package com.jayning.lowercode.layoutserviceapi.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * desc:
 * createBy: Ningjianjian
 */
@FeignClient("layout-service")
public interface LayoutClient {

    @GetMapping("/getLayout")
    String getLayout(@RequestParam String objectId, @RequestParam String buttonId);
}
