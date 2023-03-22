package com.kangam.cimeterymanagementsystem.controller;

import com.kangam.cimeterymanagementsystem.model.User;
import com.kangam.cimeterymanagementsystem.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sign_Up")
public class UserController {
    @Autowired
    private IuserService userService;
//    @PostMapping("/client")
//    public User save(@RequestBody User user){
//        return userService.saveUserAsClient(user);
//    }
    @PostMapping
    public User saveAdmin(@RequestBody User user){
        return userService.saveUserAsAdmin(user);
    }
    @GetMapping
    public List<User> listOfUsers(){
        return userService.allUsers();
    }
}
