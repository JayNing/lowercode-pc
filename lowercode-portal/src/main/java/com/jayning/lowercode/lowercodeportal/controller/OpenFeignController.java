package com.jayning.lowercode.lowercodeportal.controller;

import com.jayning.lowercode.buttonserviceapi.feignclient.ButtonClient;
import com.jayning.lowercode.layoutserviceapi.feignclient.LayoutClient;
import com.jayning.lowercode.objectserviceapi.feignclient.ObjectClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * desc:
 * createBy: Ningjianjian
 */
@RestController
public class OpenFeignController {

//    @Resource
//    private ObjectClient objectController;
//    @Resource
//    private LayoutClient layoutController;
//    @Resource
//    private ButtonClient buttonController;

    @Resource
    private ObjectClient objectClient;
    @Resource
    private LayoutClient layoutClient;
    @Resource
    private ButtonClient buttonClient;

    @RequestMapping("getPage")
    public String getPage(){

        //TODO 查询对象信息
        String object = objectClient.getObject();

        //TODO 查询按钮信息
        String button = buttonClient.getButton();

        //TODO 处理封装，返回布局
        String layout = layoutClient.getLayout(object, button);

        return layout;
    }
}
