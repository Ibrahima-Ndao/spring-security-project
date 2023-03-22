package com.kangam.cimeterymanagementsystem.service;

import com.kangam.cimeterymanagementsystem.model.User;

import java.util.List;
import java.util.Optional;

public interface IuserService {
    //User saveUserAsClient(User user);

    User saveUserAsAdmin(User user);

    Optional<User> findUserByUsername(String username);

    List<User> allUsers();
}
