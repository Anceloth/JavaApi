package com.ionix.rest.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ionix.rest.core.entities.CallMockarooApiDTO;

@Service
public class MockarooServiceImplementation implements MockarooService{
	
	private Logger LOG = LoggerFactory.getLogger(MockarooServiceImplementation.class);

	@Override
	public ResponseEntity<String> callMockarooApi(CallMockarooApiDTO dataToSend) {

		RestTemplate restTemplate  = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add(dataToSend.getHeader().split(":")[0], dataToSend.getHeader().split(":")[1]);
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		LOG.debug("URL: "+ dataToSend.getUrl()+dataToSend.getParamEncoded());
		
		ResponseEntity<String> response = restTemplate.exchange(dataToSend.getUrl()+dataToSend.getParamEncoded(), HttpMethod.GET, entity, String.class);
		LOG.debug("Object response:{}", response.getBody());

		return response;
	}

}
