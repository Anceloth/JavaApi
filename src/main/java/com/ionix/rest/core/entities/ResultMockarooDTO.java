package com.ionix.rest.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;

public class ResultMockarooDTO {
	
	@JsonIgnore
	private JsonNode items;
	private Integer registerCount;
	
	public ResultMockarooDTO() {
		
	}
	
	public ResultMockarooDTO(Integer registerCount) {
		super();
		this.registerCount = registerCount;
	}

	public Integer getRegisterCount() {
		return registerCount;
	}

	public void setRegisterCount(Integer registerCount) {
		this.registerCount = registerCount;
	}

	@Override
	public String toString() {
		return "ResultMockarooDTO [registerCount=" + registerCount + "]";
	}

	public JsonNode getItems() {
		return items;
	}

	public void setItems(JsonNode items) {
		this.items = items;
	}
	
	

}
