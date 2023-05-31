package com.ionix.rest.core.usecases;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ionix.rest.core.entities.CallMockarooApiDTO;
import com.ionix.rest.core.entities.MockarooDTO;
import com.ionix.rest.core.entities.ResultMockarooDTO;
import com.ionix.rest.external.MockarooService;

/**
 * Caso de uso que mapea la respuesta de la API Mackaroo a un objeto java,
 * calcula numero de items obtenidos y extrae el tiempo de ejecucion en milisegundos
 * @author jonathan
 */
@Component
public class CallMockarooApiUseCase implements UseCase<CallMockarooApiDTO, MockarooDTO>{
	
	private Logger LOG = LoggerFactory.getLogger(CallMockarooApiUseCase.class);
	
	@Autowired
	MockarooService service;
	
	@Override
	public MockarooDTO ejecutar(CallMockarooApiDTO input) throws Exception {
		ResponseEntity<String> response = this.service.callMockarooApi(input); 
		
		// Map to Java Object
		String stringJsonBody = response.getBody();
		LOG.debug("stringJson {}"+ stringJsonBody);
		ObjectMapper mapper = new ObjectMapper();
		MockarooDTO responseDTO = mapper.readValue(stringJsonBody, MockarooDTO.class);
		
		//Get runTime Execution
		Float runTime = Float.parseFloat(response.getHeaders().get("X-Runtime").get(0));
		responseDTO.setElapsedTime(runTime*1000);
		
		//Get number of items
		JSONObject jsonObject = new JSONObject(stringJsonBody);
		JSONObject jsonObjectResult =  jsonObject.getJSONObject("result");
		JSONArray jsonArray = jsonObjectResult.getJSONArray("items");
		
		int items = jsonArray.isEmpty() ? 0 : jsonArray.length();
		responseDTO.setResult(new ResultMockarooDTO(items));
		LOG.debug("responseDTO : {}"+ responseDTO);
		return responseDTO;
	}

}
