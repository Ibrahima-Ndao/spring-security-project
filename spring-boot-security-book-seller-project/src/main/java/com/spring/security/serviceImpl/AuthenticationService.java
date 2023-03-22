package com.spring.security.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.spring.security.jwt.IjwtProvider;
import com.spring.security.model.User;
import com.spring.security.service.IAuthentication;
import com.spring.security.usersecurity.UserPrincipal;
@Service
public class AuthenticationService implements IAuthentication {
	//@Autowired
	private AuthenticationManager  authenticationManager;
	@Autowired
	private IjwtProvider jwtProvider;
	@Override
	public User signIn(User user) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
				);
		
		UserPrincipal userprincipal = (UserPrincipal) authentication.getPrincipal();
		String token = jwtProvider.generateToken(userprincipal);
		User signInUser = userprincipal.getUser();
		signInUser.setToken(token);
		return signInUser;
	}

}
