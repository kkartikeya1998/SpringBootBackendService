package com.kk.SpringBootBackendServices.controller;

import com.kk.SpringBootBackendServices.model.User;
import com.kk.SpringBootBackendServices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userDaoService.findUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userDaoService.createUser(user);
    }

    @PutMapping("/user")
    public User updateUserById(@RequestBody User user) {
        return userDaoService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userDaoService.deleteUser(id);
    }


}