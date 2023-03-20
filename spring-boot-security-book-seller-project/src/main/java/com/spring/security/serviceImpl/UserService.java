package com.spring.security.serviceImpl;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.model.Role;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import com.spring.security.service.IuserService;


@Service
public class UserService implements IuserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreateTime(LocalDate.now());
		user.setRole(Role.USER);
		return userRepository.save(user);
	}
	
	@Override
	public Optional<User> findByUserName(String username){
		return userRepository.findByUsername(username);
	}
	
	@Override
	@Transactional
	public void makeAdmin(String username) {
		userRepository.updateUserRole(username, Role.ADMIN);
	}
}
