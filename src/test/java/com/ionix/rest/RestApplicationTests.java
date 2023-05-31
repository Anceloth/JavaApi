package com.ionix.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ionix.rest.core.entities.User;
import com.ionix.rest.external.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RestApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Integration Test
	 * Test Controller for getUserList
	 */
	@Test
	void getUserList() {
		List<User> users = new ArrayList<>();
		users.add(new User("jonathan","Jhon Wick", "jonathan@gmail.com", null));
		users.add(new User("Metatron","Metatron", "metatron@gmail.com", null));
		userRepository.saveAll(users);
		
		try {
				mockMvc.perform(get("/api/user")
				      .contentType(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk())
				      .andExpect(content()
				      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				      .andExpect(jsonPath("$[0].name", is("jonathan")));
		} catch (Exception e) {			
			e.printStackTrace();
		}	
	}
	
	/**
	 * This test create a user implementing the repository
	 */
	@Test
	void createUserTest() {
		User user = new User("Don Cangrejo","Kangreburger", "cangrejo@gmail.com", null);
		
		User userResult = userRepository.save(user);		
		assertNotNull(userResult.getId());
		
	}
	
	/**
	 * Integration Test
	 * This test must not to create a user and get Unauthorized response, because spring security
	 */
	@Test
	void springSecurityIntegrationTest() {
		User user = new User("Don Cangrejo","Kangreburger", "cangrejo@gmail.com", null);
		try {
			
			ResultActions response = mockMvc.perform(get("/api/user/create/")
			      .contentType(MediaType.APPLICATION_JSON)
				  .content(objectMapper.writeValueAsString(user)));		
			response.andDo(print())
			      .andExpect(status().isUnauthorized());
			      
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This test delete the user, implementing userRepository
	 * And getUserByEmail to assert if was deleted
	 */
	@Test
	void deleteUserTest() {
		
		User userToDelete = userRepository.getUserByEmail("cangrejo@gmail.com");	
		userRepository.delete(userToDelete);
		
		try {
			
			ResultActions response = mockMvc.perform(get("/api/user/"+userToDelete.getEmail())
			      .contentType(MediaType.APPLICATION_JSON));
			
			response.andDo(print())
			      .andExpect(status().isNotFound());
			      
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
