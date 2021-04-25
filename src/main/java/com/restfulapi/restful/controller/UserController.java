package com.restfulapi.restful.controller;

import com.restfulapi.restful.repository.UserRepository;
import com.restfulapi.restful.entity.User;
import com.restfulapi.restful.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    public UserRepository userRepository;

    //GET LIST ALL USER 
    @GetMapping("/userList")
    public List<User> getAllUser(){
        return this.userRepository.findAll();
    }

    //GET USER BY ID
    @GetMapping("/userList/{id}")
    public User getUserById(@PathVariable (value = "id") int id){
        return this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id = "+ id));
    }

    //CREATE USER
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    //UPDATE USER
    @PutMapping("")
}
