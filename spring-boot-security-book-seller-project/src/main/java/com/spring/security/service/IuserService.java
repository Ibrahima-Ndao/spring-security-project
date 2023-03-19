package com.spring.security.service;

import java.util.Optional;

import com.spring.security.model.User;

public interface IuserService {

	User saveUser(User user);

	Optional<User> findByUserName(String username);

	void makeAdmin(String username);

}
