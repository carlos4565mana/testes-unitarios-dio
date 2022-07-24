package com.carlos.api.services;

import java.util.List;

import com.carlos.api.domain.User;
import com.carlos.api.domain.dto.UserDTO;

public interface UserService {

	User findById(Integer id);

	List<User> findAll();
	
	User create(UserDTO obj);
	
	User update(UserDTO obj);
}
