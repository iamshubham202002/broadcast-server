package com.broadcast.server.cli;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClientCommand {

    public static void startClient() {
        try {
            var client = new StandardWebSocketClient();
            var session = client.doHandshake(new AbstractWebSocketHandler() {
                @Override
                protected void handleTextMessage(WebSocketSession session, TextMessage message) {
                    System.out.println(message.getPayload());
                }
            }, "ws://localhost:8080/broadcast").get();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String msg = reader.readLine();
                if (msg == null || msg.equalsIgnoreCase("exit")) break;
                session.sendMessage(new TextMessage(msg));
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
