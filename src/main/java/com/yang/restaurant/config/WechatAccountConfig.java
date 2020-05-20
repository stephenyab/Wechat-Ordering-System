package com.yang.restaurant.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName WechatAccountConfig
 * @Description
 * @Author yang
 * @Date 2020/5/14 10:35
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    //微信公众号AppId
    private String mpAppId;

    //微信公众AppSecret
    private String mpAppSecret;

    //微信模板消息id
    private Map<String, String> templateId;
}
