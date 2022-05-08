package com.billshare.models.responses;

import org.springframework.http.HttpStatus;

public class BillShareResponse {
	
	HttpStatus status;
	Object data;
	ErrorDetails errorDetails;
	public BillShareResponse(HttpStatus status, Object data, ErrorDetails error) {
		super();
		this.status = status;
		this.data = data;
		this.errorDetails = error;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}
	public void setError(ErrorDetails error) {
		this.errorDetails = error;
	}
	
}
