package com.carlos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
