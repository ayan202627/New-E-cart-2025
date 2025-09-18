package com.jwt.auth_service.service;

import com.jwt.auth_service.model.User;

import java.util.Map;

public interface GenerateJwt {
    Map<String, String> generateToken(User user);
}
