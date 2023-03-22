package com.spring.security.usersecurity;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.security.model.User;
import com.spring.security.service.IuserService;
import com.spring.security.serviceImpl.UserService;
import com.spring.security.util.SecurityUtil;

public class CustomerUserDetailsService implements UserDetailsService {
	@Autowired
	private IuserService service;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = service.findByUserName(username).orElseThrow(
				() -> new UsernameNotFoundException(username));
		
		Set<GrantedAuthority> authorities = Set.of(SecurityUtil.convertToGrantedAuthority(user.getRole().name()));
		
		return new UserPrincipal(user.getId(), username, user.getPassword(), authorities, user);
	}

}
