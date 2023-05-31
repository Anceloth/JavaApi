package com.ionix.rest.external;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ionix.rest.core.entities.CallMockarooApiDTO;

@Component
public interface MockarooService {
	
	public ResponseEntity<String> callMockarooApi(CallMockarooApiDTO dataToSend);

}
