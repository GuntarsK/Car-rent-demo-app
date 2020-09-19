package com.sda.carrent.config;

import com.sda.carrent.web.interceptors.RestControllerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private RestControllerInterceptor restControllerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restControllerInterceptor);
    }
}
