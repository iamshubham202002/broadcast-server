package com.broadcast.server.config;

import com.broadcast.server.websocket.BroadcastHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final BroadcastHandler broadcastHandler;

    public WebSocketConfig(BroadcastHandler broadcastHandler) {
        this.broadcastHandler = broadcastHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(broadcastHandler, "/broadcast")
                .setAllowedOrigins("*");
    }
}
