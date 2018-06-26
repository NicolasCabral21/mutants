package com.project.mutants.util;

public class RestResponse {

	private Integer responseCode;
	private String message;
	
	public RestResponse(Integer resposenCode){
		super();
		this.responseCode = resposenCode;
	}
	
	public RestResponse(Integer resposenCode, String message){
		super();
		this.responseCode = resposenCode;
		this.message = message;
	}
	
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
