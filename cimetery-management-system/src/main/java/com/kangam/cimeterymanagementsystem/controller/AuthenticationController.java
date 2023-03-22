package com.kangam.cimeterymanagementsystem.controller;

import com.kangam.cimeterymanagementsystem.model.User;
import com.kangam.cimeterymanagementsystem.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sign_In")
public class AuthenticationController {
    @Autowired
    private IAuthenticationService authenticationService;
    @PostMapping
    public ResponseEntity<User> singIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signIn(user), HttpStatus.CREATED);
    }
}
