package com.ionix.rest.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ionix.rest.core.entities.CallMockarooApiDTO;
import com.ionix.rest.core.entities.MockarooDTO;
import com.ionix.rest.core.usecases.CallMockarooApiUseCase;
import com.ionix.rest.core.usecases.CodeParamUsingDESUseCase;


@RestController
@RequestMapping("/api/external")
public class MockarooController {
	
	private Logger LOG = LoggerFactory.getLogger(MockarooController.class);
	
	@Autowired
	private CodeParamUsingDESUseCase codeParamUsingDESUseCase;
	@Autowired
	private CallMockarooApiUseCase callMockarooApiUseCase;
	
	@Value("${mockaroo.url}")
	private String mockarooUrl;
	
	@Value("${mockaroo.header}")
	private String mockarooHeader;
	
	 @PostMapping()
	    public ResponseEntity<MockarooDTO> consumeMockarooApi(@RequestParam(value = "param") String param) {
	    	Optional<MockarooDTO> responseDTO;
	    	String paramEncoded;
	        try {
	        	// Cifrar param
	        	LOG.debug("Encoding Param : "+ param); 	
				paramEncoded = codeParamUsingDESUseCase.ejecutar(param);
				LOG.debug("Param Encoded: "+ paramEncoded);
				
				// LLamar al API con el Param cifrado
				CallMockarooApiDTO dataToSend = new CallMockarooApiDTO(mockarooUrl, paramEncoded, mockarooHeader); 
				MockarooDTO response = callMockarooApiUseCase.ejecutar(dataToSend);				
				responseDTO = Optional.of(response);
				return ResponseEntity.ok().body(responseDTO.get());
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}
	    }

}
