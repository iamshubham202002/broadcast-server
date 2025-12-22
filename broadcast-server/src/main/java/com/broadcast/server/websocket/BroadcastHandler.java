package com.broadcast.server.websocket;

import com.broadcast.server.auth.AuthService;
import com.broadcast.server.registry.ClientRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class BroadcastHandler extends TextWebSocketHandler {

    private final AuthService authService;

    public BroadcastHandler(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage("Welcome! Login as: username:password"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        if (!ClientRegistry.getAll().containsKey(session)) {
            if (!payload.contains(":")) {
                session.sendMessage(new TextMessage("Invalid format. Use username:password"));
                return;
            }
            String[] parts = payload.split(":", 2);
            String username = parts[0];
            String password = parts[1];

            if (authService.authenticate(username, password)) {
                ClientRegistry.add(session, username);
                session.sendMessage(new TextMessage("Login successful! Welcome " + username));
                broadcastMessage(username + " joined the chat!", session);
            } else {
                session.sendMessage(new TextMessage("Authentication failed!"));
            }
            return;
        }

        String username = ClientRegistry.getAll().get(session);
        broadcastMessage(username + ": " + payload, session);
    }

    private void broadcastMessage(String message, WebSocketSession sender) throws Exception {
        for (WebSocketSession client : ClientRegistry.getAll().keySet()) {
            if (client.isOpen()) client.sendMessage(new TextMessage(message));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        String username = ClientRegistry.getAll().get(session);
        ClientRegistry.remove(session);
        if (username != null) {
            try { broadcastMessage(username + " left the chat.", session); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
