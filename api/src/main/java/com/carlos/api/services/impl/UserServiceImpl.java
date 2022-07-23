package com.carlos.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.api.domain.User;
import com.carlos.api.repositories.UserRepository;
import com.carlos.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	
	@Override
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
