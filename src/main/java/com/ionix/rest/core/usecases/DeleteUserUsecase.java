package com.ionix.rest.core.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ionix.rest.external.UserRepository;

@Component
public class DeleteUserUsecase implements UseCase<Long, Integer>{
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public Integer ejecutar(Long id) throws Exception {
		this.userRepository.deleteById(id);
		return 200;
	}

}
