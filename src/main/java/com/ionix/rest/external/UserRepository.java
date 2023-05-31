package com.ionix.rest.external;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ionix.rest.core.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query(value = "SELECT * FROM user u WHERE u.email LIKE %?%1", nativeQuery = true)
	public User getUserByEmail(String email);
	
}
