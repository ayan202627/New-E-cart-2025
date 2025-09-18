package com.jwt.auth_service.repository;

import com.jwt.auth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    //User findByEmailidAndPassword(String emailid, String password);
    Optional<User> findByEmailidAndPassword(String emailid, String password);
}
