package com.restfulapi.restful.service;
import com.restfulapi.restful.entity.User;
import java.util.List;

import com.restfulapi.restful.entity.User;
import com.restfulapi.restful.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    
}
