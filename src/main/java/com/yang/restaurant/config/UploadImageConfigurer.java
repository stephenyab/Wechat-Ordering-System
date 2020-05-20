package com.yang.restaurant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName UploadImageConfigurer
 * @Description
 * @Author yang
 * @Date 2020/5/18 16:19
 * @Version 1.0
 */
@Configuration
public class UploadImageConfigurer implements WebMvcConfigurer {

    @Autowired
    private ProjectUrl projectUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/product/**").addResourceLocations(projectUrl.getImagesResourceLocationsUrl());
    }
}
