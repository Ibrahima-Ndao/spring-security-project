package com.kangam.cimeterymanagementsystem.service;

import com.kangam.cimeterymanagementsystem.model.Role;
import com.kangam.cimeterymanagementsystem.model.User;
import com.kangam.cimeterymanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IuserService {
    @Autowired
    private UserRepository userRepository;
    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Override
//    public User saveUserAsClient(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole(Role.CLIENT);
//        return userRepository.save(user);
//    }
    @Override
    public User saveUserAsAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        return userRepository.save(user);
    }
    @Override
    public Optional<User> findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    public List<User> allUsers(){
        return userRepository.findAll();
    }
}
