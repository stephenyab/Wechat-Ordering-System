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
 * @ClassName AdminWebSocket
 * @Description
 * @Author yang
 * @Date 2020/5/14 10:37
 * @Version 1.0
 */
@Slf4j
@Component
@ServerEndpoint("/webSocket/admin")
public class AdminWebSocket {

    private Session session;

    private static CopyOnWriteArraySet<AdminWebSocket> AdminWebSocket = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        AdminWebSocket.add(this);
        log.info("【websocket消息】有新的链接，总数：{}", AdminWebSocket.size());
    }

    @OnClose
    public void onClose() {
        AdminWebSocket.remove(this);
        log.info("【websocket消息】链接断开，总数：{}", AdminWebSocket.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息：{}", message);
    }

    public void sendMessage(String message) {
        for (AdminWebSocket adminWebSocket : AdminWebSocket) {
            log.info("【websocket消息】广播消息，message={}", message);
            try {
                adminWebSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
