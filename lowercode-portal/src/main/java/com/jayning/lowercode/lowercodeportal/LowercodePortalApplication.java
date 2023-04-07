package com.jayning.lowercode.lowercodeportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.jayning.lowercode.buttonserviceapi.feignclient",
        "com.jayning.lowercode.objectserviceapi.feignclient","com.jayning.lowercode.layoutserviceapi.feignclient"})
@SpringBootApplication
public class LowercodePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LowercodePortalApplication.class, args);
    }

}
