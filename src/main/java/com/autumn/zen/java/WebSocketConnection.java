package com.autumn.zen.java;

import org.apache.log4j.Logger;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Web Socket Connection
 *
 * @author zhikong.wl
 * 2017-10-14 11:36
 **/
@ServerEndpoint("/websocket")
public class WebSocketConnection {

    public static final Logger LOG = Logger.getLogger(WebSocketConnection.class);

    @OnMessage
    public void onMessage(String msg,Session session) throws IOException {
        LOG.info("received msg: " + msg);
        session.getBasicRemote().sendText("First Message");
        session.getBasicRemote().sendText("Second Message");
        session.getBasicRemote().sendText("Last Message");
    }

}
