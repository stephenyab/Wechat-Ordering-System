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
 * @ClassName ChiefWebSocket
 * @Description
 * @Author yang
 * @Date 2020/5/14 10:38
 * @Version 1.0
 */
@Slf4j
@Component
@ServerEndpoint("/webSocket/chief")
public class ChiefWebSocket {

    private Session session;

    private static CopyOnWriteArraySet<ChiefWebSocket> chiefWebSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        chiefWebSocketSet.add(this);
        log.info("【websocket消息】有新的链接，总数：{}", chiefWebSocketSet.size());
    }

    @OnClose
    public void onClose() {
        chiefWebSocketSet.remove(this);
        log.info("【websocket消息】链接断开，总数：{}", chiefWebSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息：{}", message);
    }

    public void sendMessage(String message) {
        for (ChiefWebSocket chiefWebSocket : chiefWebSocketSet) {
            log.info("【websocket消息】广播消息，message={}", message);
            try {
                chiefWebSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
