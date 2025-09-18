package com.jwt.auth_service.service;

import com.jwt.auth_service.model.User;
import com.jwt.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    @Override
    public User addUser(User user) {
//        User temp = new User();
//        temp.setEmailid(user.getEmailid());
//        ResponseEntity resp = restTemplate.postForEntity("http://localhost:9090/user/addUserOrder",temp,Void.class);
//        System.out.println(resp);

        user.setRole("USER_ROLE");
        user.setStatus("ACTIVE");
        return userRepository.save(user); // MySQL
    }
    @Override
    public User loginCheck(String emailid, String password) {
        //User result = userRepository.findByEmailidAndPassword(emailid,password);
        User result = userRepository.findByEmailidAndPassword(emailid,password).get();
        System.out.println(result);
        return result;
    }
}
