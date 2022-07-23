package com.carlos.api.services;

import java.util.List;

import com.carlos.api.domain.User;

public interface UserService {

	User findById(Integer id);

	List<User> findAll();
}
