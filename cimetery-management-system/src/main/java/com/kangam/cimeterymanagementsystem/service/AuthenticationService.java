package com.kangam.cimeterymanagementsystem.service;

import com.kangam.cimeterymanagementsystem.jwt.IjwtProvider;
import com.kangam.cimeterymanagementsystem.model.User;
import com.kangam.cimeterymanagementsystem.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IjwtProvider jwtProvider;
    @Override
    public User signIn(User user){
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authenticate.getPrincipal();
        String token = jwtProvider.generateToken(userPrincipal);
        User signInUser = userPrincipal.getUser();
        signInUser.setToken(token);
        return signInUser;
    }
}
