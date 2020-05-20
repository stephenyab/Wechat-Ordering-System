package com.yang.restaurant.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProjectUrl
 * @Description
 * @Author yang
 * @Date 2020/5/14 10:40
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "project-url")
public class ProjectUrl {

    //webSocket通信地址
    public String webSocketUrl;

    //微信公众平台授权url
    public String wechatMpAuthorize;

    public String imagesResourceLocationsUrl;

    public String imagesRealLocationsUrl;
}
