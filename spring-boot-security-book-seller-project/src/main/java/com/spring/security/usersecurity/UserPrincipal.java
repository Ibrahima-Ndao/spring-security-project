package com.spring.security.usersecurity;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.security.model.User;

import lombok.Builder;
@Builder
public class UserPrincipal implements UserDetails{
	private Long id;
	private String username;
	transient private String password;
	private Set<GrantedAuthority> authorities;
	transient private User user;
	
	public UserPrincipal() {
	}

	public UserPrincipal(Long id, String username, String password, Set<GrantedAuthority> authorities, User user) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.user = user;
	}
	
	public UserPrincipal(Long id, String username, Set<GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}
	
}
