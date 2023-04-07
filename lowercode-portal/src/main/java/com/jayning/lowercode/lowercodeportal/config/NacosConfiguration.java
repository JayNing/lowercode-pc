package com.jayning.lowercode.lowercodeportal.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * desc:
 * createBy: Ningjianjian
 */
@Data
@RefreshScope //用来标注进行nacos配置自动刷新的注解
@Configuration
public class NacosConfiguration {

    @Value("${errorCode}")
    private int errorCode;

    @Value("${errorMsg}")
    private String errorMsg;
}
