package com.ionix.rest.core.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ionix.rest.core.entities.User;
import com.ionix.rest.external.UserRepository;

@Component
public class CreateUserUseCase implements UseCase<User, User>{
	
    @Autowired
    private UserRepository userRepository;

	@Override
	public User ejecutar(User user) throws Exception {
		return this.userRepository.save(user);
	}

}
