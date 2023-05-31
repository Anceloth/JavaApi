package com.ionix.rest.core.entities;


public class MockarooDTO {
	
	private int responseCode;
	private String description;
	private Float elapsedTime;
	private ResultMockarooDTO result;
	
	public MockarooDTO() {
		this.result = new ResultMockarooDTO();
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Float elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public ResultMockarooDTO getResult() {
		return result;
	}

	public void setResult(ResultMockarooDTO result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "MockarooDTO [responseCode=" + responseCode + ", description=" + description + ", elapsedTime="
				+ elapsedTime + ", result=" + result + "]";
	}
	
	

}
