package com.broadcast.server.auth;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {
    private final Map<String, String> userDB = new ConcurrentHashMap<>();

    public AuthService() {
        userDB.put("shubham", "pass123");
        userDB.put("prashant", "pass456");
        userDB.put("tempo", "pass789");
    }

    public boolean authenticate(String username, String password) {
        return userDB.containsKey(username) && userDB.get(username).equals(password);
    }
}
