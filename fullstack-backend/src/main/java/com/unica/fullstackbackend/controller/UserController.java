package com.unica.fullstackbackend.controller;

import com.unica.fullstackbackend.exception.UserNotFoundException;
import com.unica.fullstackbackend.model.User;
import com.unica.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addNew")
    User newUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }
    @GetMapping("/view_all")
    List<User> viewAll(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    Optional<User> getUserById(@PathVariable Long id){
        return Optional.ofNullable(userService.getUserById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }
    @PutMapping("/{id}")
    User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user);
    }
}
