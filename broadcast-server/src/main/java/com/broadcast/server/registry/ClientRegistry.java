package com.broadcast.server.registry;

import org.springframework.web.socket.WebSocketSession;
import java.util.concurrent.ConcurrentHashMap;

public class ClientRegistry {
    private static final ConcurrentHashMap<WebSocketSession, String> clients = new ConcurrentHashMap<>();

    public static void add(WebSocketSession session, String username) {
        clients.put(session, username);
    }

    public static void remove(WebSocketSession session) {
        clients.remove(session);
    }

    public static ConcurrentHashMap<WebSocketSession, String> getAll() {
        return clients;
    }
}
