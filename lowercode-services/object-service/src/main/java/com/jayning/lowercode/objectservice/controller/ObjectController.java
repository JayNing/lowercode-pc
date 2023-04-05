package com.jayning.lowercode.objectservice.controller;

import com.jayning.lowercode.objectserviceapi.feignclient.ObjectClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 * createBy: Ningjianjian
 */
@RestController
public class ObjectController implements ObjectClient {

    @GetMapping("/getObject")
    public String getObject(){
        return "object_123";
    }
}
