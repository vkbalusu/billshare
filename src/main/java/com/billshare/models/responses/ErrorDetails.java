package com.billshare.models.responses;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorDetails {
	
	private LocalDateTime timeStamp;
	private List<String> errorMessages;
	private String stackTrace;
	
	public ErrorDetails(List<String> errorMessage, String stackTrace) {
		super();
		this.errorMessages = errorMessage;
		this.stackTrace = stackTrace;
		this.timeStamp = LocalDateTime.now();
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessage) {
		this.errorMessages = errorMessage;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
