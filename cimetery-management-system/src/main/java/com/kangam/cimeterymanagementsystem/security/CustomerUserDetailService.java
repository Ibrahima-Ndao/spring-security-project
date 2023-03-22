package com.kangam.cimeterymanagementsystem.security;

import com.kangam.cimeterymanagementsystem.model.User;
import com.kangam.cimeterymanagementsystem.service.IuserService;
import com.kangam.cimeterymanagementsystem.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private IuserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );
        Set<GrantedAuthority> authorities = Set.of(
                SecurityUtil.convertToGranted(
                        user.getRole().name()
                )
        );
        return UserPrincipal.builder()
                .user(user)
                .id(user.getId())
                .authorities(authorities)
                .password(user.getPassword())
                .username(username)
                .build();
    }
}
