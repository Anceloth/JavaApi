package com.ionix.rest.external;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ionix.rest.core.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User getUserByEmail(String email);
	
}
