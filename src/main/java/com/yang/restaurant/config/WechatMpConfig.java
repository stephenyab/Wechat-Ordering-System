package com.yang.restaurant.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName WechatMpConfig
 * @Description
 * @Author yang
 * @Date 2020/5/14 10:36
 * @Version 1.0
 */
@Component
public class WechatMpConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpDefaultConfig());
        return wxMpService;
    }

    @Bean
    public WxMpDefaultConfigImpl wxMpDefaultConfig() {
        WxMpDefaultConfigImpl wxMpDefaultConfig = new WxMpDefaultConfigImpl();
        wxMpDefaultConfig.setAppId(accountConfig.getMpAppId());
        wxMpDefaultConfig.setSecret(accountConfig.getMpAppSecret());
        return wxMpDefaultConfig;
    }
}
