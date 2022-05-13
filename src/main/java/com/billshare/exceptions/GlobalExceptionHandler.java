package com.billshare.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.billshare.models.responses.BillShareResponse;
import com.billshare.models.responses.ErrorDetails;
import com.billshare.utils.ExceptionMessages;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
		
	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<BillShareResponse> handleResponseNotFoundException(RecordNotFoundException exception){
		ErrorDetails errorDetails = new ErrorDetails(new ArrayList<String>(Arrays.asList(exception.getMessage())), null);
		BillShareResponse response = new BillShareResponse(HttpStatus.NOT_FOUND, null, errorDetails);
		return new ResponseEntity<BillShareResponse>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = RecordAlreadyExistsException.class)
	public ResponseEntity<BillShareResponse> handleRecordAlreadyExistsException(RecordAlreadyExistsException exception){
		ErrorDetails errorDetails = new ErrorDetails(new ArrayList<String>(Arrays.asList(exception.getMessage())), null);
		BillShareResponse response = new BillShareResponse(HttpStatus.CONFLICT, null, errorDetails);
		return new ResponseEntity<BillShareResponse>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = AuthenticationException.class)
	public ResponseEntity<BillShareResponse> handleAuthenticationException(AuthenticationException exception){
		ErrorDetails errorDetails = new ErrorDetails(new ArrayList<String>(Arrays.asList(exception.getMessage())), null);
		BillShareResponse response = new BillShareResponse(HttpStatus.UNAUTHORIZED, null, errorDetails);
		return new ResponseEntity<BillShareResponse>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = BillShareException.class)
	public ResponseEntity<BillShareResponse> handleBillShareException(BillShareException exception){
		ErrorDetails errorDetails = new ErrorDetails(new ArrayList<String>(Arrays.asList(exception.getMessage())), null);
		BillShareResponse response = new BillShareResponse(HttpStatus.BAD_REQUEST, null, errorDetails);
		return new ResponseEntity<BillShareResponse>(response, HttpStatus.OK);
	}
	
	//fall back method - used if no exception handler method matches
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<BillShareResponse> handleException(Exception exception){
		ErrorDetails errorDetails = new ErrorDetails(new ArrayList<String>(Arrays.asList(ExceptionMessages.ERROR_IN_PROCESSING)), getStackTrace(exception));
		BillShareResponse response = new BillShareResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, errorDetails);
		return new ResponseEntity<BillShareResponse>(response, HttpStatus.OK);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new ArrayList<String>(Arrays.asList(ExceptionMessages.IMPROPER_DATA)), null);
		BillShareResponse response = new BillShareResponse(HttpStatus.BAD_REQUEST, null, errorDetails);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		List<String> errorMessages = new LinkedList<>();
		for(FieldError error : fieldErrors) {
			errorMessages.add(error.getDefaultMessage());
		}
		BillShareResponse response = new BillShareResponse(HttpStatus.BAD_REQUEST, null, new ErrorDetails(errorMessages, null));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new ArrayList<String>(Arrays.asList(ex.getMessage())), null);
		BillShareResponse response = new BillShareResponse(HttpStatus.BAD_REQUEST, null, errorDetails);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private String getStackTrace(Exception exception) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		exception.printStackTrace(printWriter);
		return stringWriter.toString();
	}
	
}
