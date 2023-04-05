package com.jayning.lowercode.buttonservice.controller;

import com.jayning.lowercode.buttonserviceapi.feignclient.ButtonClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 * createBy: Ningjianjian
 */
@Slf4j
@RestController
public class ButtonController implements ButtonClient {

    @Value("${server.port}")
    private int port;

    @GetMapping("/getButton")
    public String getButton(){
        return "buttonId_123" + "port:" + port;
    }

}
