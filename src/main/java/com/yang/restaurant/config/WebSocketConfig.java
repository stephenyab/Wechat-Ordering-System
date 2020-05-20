package com.yang.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName WebSocketConfig
 * @Description
 * @Author yang
 * @Date 2020/5/14 10:35
 * @Version 1.0
 */
@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
