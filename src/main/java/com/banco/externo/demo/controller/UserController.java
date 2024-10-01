package com.banco.externo.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.externo.demo.model.User;
import com.banco.externo.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/api/v1/user/")
@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping(value = "/add")
    public User insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @GetMapping(value = "/id/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping(value = "updateName/{id}") 
    public User updateNameUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateNameUser(id, user.getName());
    }
}
