package com.ionix.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ionix.rest.core.entities.User;
import com.ionix.rest.core.usecases.CreateUserUseCase;
import com.ionix.rest.core.usecases.DeleteUserUsecase;
import com.ionix.rest.core.usecases.GetUserByEmailUsecase;
import com.ionix.rest.core.usecases.GetUserListUseCase;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private Logger LOG = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private DeleteUserUsecase deleteUserUsecase;
    @Autowired
    private GetUserListUseCase getUserListUseCase;
    @Autowired
    private GetUserByEmailUsecase getUserByEmailUsecase;
        
    @GetMapping
    public List<User> findAllUsers() {
    	List<User> allUsers = new ArrayList<User>();
        try {
        	LOG.debug("Getting all users");
        	allUsers = getUserListUseCase.ejecutar(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUsers;
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable(value = "email") String email) {
    	Optional<User> user;
        try {
        	LOG.debug("Getting user By email : ", email);
			user = Optional.of(getUserByEmailUsecase.ejecutar(email));
			return ResponseEntity.ok().body(user.get());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
    }

    @PostMapping("/create/")
    public User createUser(@Validated @RequestBody User user) {
        try {
        	LOG.debug("Creating user: ", user);
			return createUserUseCase.ejecutar(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @DeleteMapping("/delete/{id}")  
    public void deleteUser(@PathVariable(value = "id") Long id) {
    	try {
			deleteUserUsecase.ejecutar(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
