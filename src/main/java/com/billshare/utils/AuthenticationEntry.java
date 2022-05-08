package com.billshare.utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.billshare.models.responses.BillShareResponse;
import com.billshare.models.responses.ErrorDetails;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class AuthenticationEntry implements AuthenticationEntryPoint, Serializable {
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		ErrorDetails errorDetails = new ErrorDetails(new ArrayList<String>(Arrays.asList(ExceptionMessages.NO_AUTH_TOKEN)), null);
		BillShareResponse errorResponse = new BillShareResponse(HttpStatus.UNAUTHORIZED, null, errorDetails);
    	response.setContentType("application/json");
        response.setStatus(200);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
	}
}








