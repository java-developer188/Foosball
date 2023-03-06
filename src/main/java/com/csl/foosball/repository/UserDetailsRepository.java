package com.csl.foosball.repository;

import org.springframework.data.repository.CrudRepository;

import com.csl.foosball.model.User;



public interface UserDetailsRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
