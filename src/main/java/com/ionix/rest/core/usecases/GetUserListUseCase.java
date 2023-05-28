package com.ionix.rest.core.usecases;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ionix.rest.core.entities.User;
import com.ionix.rest.external.UserRepository;

@Component
public class GetUserListUseCase implements UseCase< String, List<User>>{
	private Logger LOG = LoggerFactory.getLogger(GetUserListUseCase.class);
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public List<User> ejecutar(String input) throws Exception {
		LOG.debug("Finding all users from use case");
		return (List<User>) this.userRepository.findAll();
	}

}
