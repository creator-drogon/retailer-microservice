package com.config.server.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoHystrix {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    EurekaClient eurekaClient;

    @HystrixCommand(fallbackMethod="defaultHystrixGreeting")
    public String getGreeting(String username){
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("client-1", false);
        String baseUrl =instanceInfo.getHomePageUrl();
        baseUrl = baseUrl+"/hystrix/"+username;
        System.out.println(baseUrl);
        return restTemplate.getForObject(baseUrl, String.class);
    }

    public String defaultHystrixGreeting(String username){
        return "Server is down";
    }
}
