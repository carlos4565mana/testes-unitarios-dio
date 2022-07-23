package com.carlos.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carlos.api.domain.User;
import com.carlos.api.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {

	@Autowired
	private UserRepository repository;
	
	@Bean
	public void startDB() {
		User u1 = new User(null, "Carlos","carlos@gmail.com","123");
		User u2 = new User(null, "João","joaos@gmail.com","12345");
		
		repository.saveAll(List.of(u1,u2));
	}
}
