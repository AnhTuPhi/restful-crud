package com.restfulapi.restful.controller;

import com.restfulapi.restful.repository.UserRepository;
import com.restfulapi.restful.entity.User;
import com.restfulapi.restful.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @PutMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User user, @PathVariable (value = "id") int id){
        User existingUser = this.userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found user id " + id));
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        return this.userRepository.save(existingUser);
    }

    //DELETE USER
    @DeleteMapping("/userList/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable (value = "id") int id){
        User existingUser = this.userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found user id " + id));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}
