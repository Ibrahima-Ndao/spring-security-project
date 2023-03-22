package com.spring.security.service;

import com.spring.security.model.User;

public interface IAuthentication {
	User signIn(User user);
}
