package com.kangam.cimeterymanagementsystem.service;

import com.kangam.cimeterymanagementsystem.model.User;

public interface IAuthenticationService {
    User signIn(User user);
}
