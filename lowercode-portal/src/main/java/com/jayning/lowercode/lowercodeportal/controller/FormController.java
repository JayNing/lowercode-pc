package com.jayning.lowercode.lowercodeportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * desc:
 * createBy: Ningjianjian
 */
@RestController
@RequestMapping("form")
public class FormController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("createPage")
    public String getCreatePage(){

        //TODO 查询对象信息
        String object = restTemplate.getForObject("http://object-service/getObject", String.class);

        //TODO 查询按钮信息
        String button = restTemplate.getForObject("http://button-service/getButton", String.class);

        //TODO 处理封装，返回布局
        String layout = restTemplate.getForObject("http://layout-service/getLayout?objectId="+object+"&buttonId="+button, String.class);

        return layout;
    }

}
