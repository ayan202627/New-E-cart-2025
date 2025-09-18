package com.jwt.auth_service.service;

import com.jwt.auth_service.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GenerateJwtImpl implements GenerateJwt{
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String, String> result = new HashMap<>();

        Map<String, Object> claims = new HashMap<>();
        claims.put("userEmailId",user.getEmailid());
        claims.put("userName",user.getName());
        claims.put("role",user.getRole());

            String jwt = Jwts.builder()
                   // .setSubject("testing jwt")
                   // .setIssuer("auth-app")
                    .setClaims(claims)
                    .signWith(SignatureAlgorithm.HS256,"idontsay")
                    .compact();
            result.put("token",jwt);
        return result;
    }
}
