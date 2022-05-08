package com.billshare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.billshare.exceptions.AuthenticationException;
import com.billshare.models.AuthenticationRequest;
import com.billshare.models.AuthenticationResponse;
import com.billshare.services.AuthenticationService;
import com.billshare.utils.AuthenticationUtils;
import com.billshare.utils.ExceptionMessages;

@Controller
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private AuthenticationUtils authenticationUtils;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> generateAuthenticationToken(@RequestBody AuthenticationRequest request){
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassWord()));
		}catch (BadCredentialsException exception) {
			throw new AuthenticationException(ExceptionMessages.UNAUTHORISED_USER);
		}
		
		final UserDetails userDetails = authenticationService.loadUserByUsername(request.getUserName());
		
		String token = authenticationUtils.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
}
