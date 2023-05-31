package com.ionix.rest.core.entities;

public class CallMockarooApiDTO {
	
	private String url;
	private String paramEncoded;
	private String header; 
	
	public CallMockarooApiDTO() {
		
	}
	
	public CallMockarooApiDTO(String url, String paramEncoded, String header) {
		super();
		this.url = url;
		this.paramEncoded = paramEncoded;
		this.header = header;
	}

	@Override
	public String toString() {
		return "CallMockarooApiDTO [url=" + url + ", paramEncoded=" + paramEncoded + ", header=" + header + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParamEncoded() {
		return paramEncoded;
	}

	public void setParamEncoded(String paramEncoded) {
		this.paramEncoded = paramEncoded;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}


}
