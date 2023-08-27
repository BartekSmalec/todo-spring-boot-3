package com.bartek.todospringboot3.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authentication(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("in28minutes");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");

        return isValidPassword && isValidUserName;
    }
}
