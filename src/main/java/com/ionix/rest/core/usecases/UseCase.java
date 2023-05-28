package com.ionix.rest.core.usecases;

import org.springframework.stereotype.Component;

@Component
public interface UseCase<Argument, Result> {
	
	public Result ejecutar(Argument input) throws Exception;

}
