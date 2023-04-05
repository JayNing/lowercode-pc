package com.jayning.lowercode.layoutservice.controller;

import com.jayning.lowercode.layoutserviceapi.feignclient.LayoutClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 * createBy: Ningjianjian
 */
@RestController
public class LayoutController implements LayoutClient {

    @GetMapping("/getLayout")
    public String getLayout(@RequestParam String objectId, @RequestParam String buttonId){
        return "layoutId_123::" + objectId + "::" + buttonId;
    }
}
