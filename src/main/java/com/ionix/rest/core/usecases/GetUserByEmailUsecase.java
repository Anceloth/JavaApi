package com.ionix.rest.core.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ionix.rest.core.entities.User;
import com.ionix.rest.external.UserRepository;

@Component
public class GetUserByEmailUsecase implements UseCase<String, User>{
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public User ejecutar(String email) throws Exception {
		return this.userRepository.getUserByEmail(email);
	}

}
