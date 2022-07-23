package com.carlos.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.api.domain.User;
import com.carlos.api.repositories.UserRepository;
import com.carlos.api.services.UserService;
import com.carlos.api.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	
	@Override
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found..."));
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}

}
