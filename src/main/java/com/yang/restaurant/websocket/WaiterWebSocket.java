package com.yang.restaurant.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName WaiterWebSocket
 * @Description
 * @Author yang
 * @Date 2020/5/14 10:38
 * @Version 1.0
 */
@Slf4j
@Component
@ServerEndpoint("/webSocket/waiter")
public class WaiterWebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WaiterWebSocket> waiterWebSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        waiterWebSocketSet.add(this);
        log.info("【websocket消息】有新的链接，总数：{}", waiterWebSocketSet.size());
    }

    @OnClose
    public void onClose() {
        waiterWebSocketSet.remove(this);
        log.info("【websocket消息】链接断开，总数：{}", waiterWebSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息：{}", message);
    }

    public void sendMessage(String message) {
        for (WaiterWebSocket waiterWebSocket : waiterWebSocketSet) {
            log.info("【websocket消息】广播消息，message={}", message);
            try {
                waiterWebSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
