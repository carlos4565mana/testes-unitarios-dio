package com.carlos.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.api.domain.User;
import com.carlos.api.domain.dto.UserDTO;
import com.carlos.api.repositories.UserRepository;
import com.carlos.api.services.UserService;
import com.carlos.api.services.exceptions.DataIntegratyViolationException;
import com.carlos.api.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found..."));
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}

	@Override
	public User create(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}
	
	private void findByEmail(UserDTO obj) {
		Optional<User> user = repository.findByEmail(obj.getEmail());
		if(user.isPresent() && !user.get().getId().equals(obj.getId())) {
			throw new DataIntegratyViolationException("E-mail already registered.");
		}
	}

	@Override
	public User update(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}

}
