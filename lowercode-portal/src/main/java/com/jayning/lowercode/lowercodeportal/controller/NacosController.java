package com.jayning.lowercode.lowercodeportal.controller;

//import com.jayning.lowercode.lowercodeportal.config.NacosConfigProperties;
import com.jayning.lowercode.lowercodeportal.config.NacosConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * desc:
 * createBy: Ningjianjian
 */
@RefreshScope
@RestController
public class NacosController {

    @Resource
    private NacosConfiguration nacosConfiguration;

    @Value(value = "${errorCode:123}")
    private int errorCode;

    @Value(value = "${errorMsg:lalala}")
    private String errorMsg;

    @GetMapping("/nacos")
    public String getNacosConfig(){
        return errorCode + "_" + errorMsg;
    }

    /**
     * 通过专门的配置，将@RefreshScope写在配置类上，不用每个使用的@Value的地方都存一份
     * @return
     */
    @GetMapping("/nacos2")
    public String getNacosConfig2(){
        return nacosConfiguration.getErrorCode() + "_" + nacosConfiguration.getErrorMsg();
    }

}
