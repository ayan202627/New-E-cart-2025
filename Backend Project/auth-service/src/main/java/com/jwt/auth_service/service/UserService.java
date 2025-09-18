package com.jwt.auth_service.service;

import com.jwt.auth_service.model.User;

public interface UserService {
    User addUser(User user);
    User loginCheck(String emailid, String password);
}
