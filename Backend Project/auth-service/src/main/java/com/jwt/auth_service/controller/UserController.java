package com.jwt.auth_service.controller;

import com.jwt.auth_service.model.User;
import com.jwt.auth_service.service.GenerateJwt;
import com.jwt.auth_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/auth-app")
public class UserController {

    @Autowired
    private GenerateJwt generateJwt;

    @Autowired
    private UserService userService;



    // http://localhost:8080/auth-app/register-user   [POST]
    @PostMapping("/register-user")
    public ResponseEntity addUser(@RequestBody User user){
        return new ResponseEntity(userService.addUser(user), HttpStatus.CREATED);
    }

    // http://localhost:8080/auth-app/login-check   [POST]
    @PostMapping("/login-check")
    public ResponseEntity loginCheck(@RequestBody User user){
        User result = userService.loginCheck(user.getEmailid(), user.getPassword());
        if(result!=null) { // login success
            //return new ResponseEntity(result, HttpStatus.OK);
            return new ResponseEntity(generateJwt.generateToken(result),HttpStatus.OK);
        }
        else{
            return new ResponseEntity("Login failed...", HttpStatus.OK);
        }
    }
}
