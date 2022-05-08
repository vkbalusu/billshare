package com.billshare.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billshare.entities.User;
import com.billshare.exceptions.RecordNotFoundException;
import com.billshare.models.forms.CreateUserForm;
import com.billshare.models.forms.UpdateUserForm;
import com.billshare.models.responses.BillShareResponse;
import com.billshare.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public String greet() {
		return "Hello World";
	}
	
	//to do: pagination
	@GetMapping()
	public ResponseEntity<BillShareResponse> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, users, null));
	}
	
	@GetMapping("/user")
	public ResponseEntity<BillShareResponse> getUserInfo(@RequestHeader(value = "Authorization") String token) throws RecordNotFoundException{
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, userService.findUser(token), null));
	}
	
	
	@PostMapping
	public ResponseEntity<BillShareResponse> registerNewUser(@Valid @RequestBody CreateUserForm form) {
		User user = userService.createUser(form);
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, user, null));
	}
	
	@PutMapping
	public ResponseEntity<BillShareResponse> updateExistingUser(@Valid @RequestBody UpdateUserForm form, @RequestHeader(value = "Authorization") String token) {
		User user = userService.updateUser(form, token);
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, user, null));
	}
	
}
