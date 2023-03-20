package com.spring.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.spring.security.usersecurity.UserPrincipal;

public interface IjwtProvider {

	String generateToken(UserPrincipal user);

	Authentication getAuthentication(HttpServletRequest request);

	boolean validateToken(HttpServletRequest request);

}
