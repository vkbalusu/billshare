package com.billshare.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billshare.entities.UserEntity;
import com.billshare.mappers.UserDTOMapper;
import com.billshare.models.dtos.UserDTO;
import com.billshare.models.forms.CreateUserForm;
import com.billshare.models.forms.UpdateUserForm;
import com.billshare.models.responses.BillShareResponse;
import com.billshare.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDTOMapper userMapper;

	@GetMapping("/hello")
	public String greet() {
		return "Hello World";
	}
	
	//to do: pagination
	@GetMapping()
	public ResponseEntity<BillShareResponse> getAllUsers(){
		List<UserEntity> users = userService.getAllUsers();
		List<UserDTO> userDTOs = users.stream().map(user -> userMapper.convertEntityToDTO(user)).collect(Collectors.toList());
//		for(UserEntity user : users) {
//			UserDTO userDTO = new UserDTO();
//			userMapper.convertEntityToDTO(user, userDTO);
//			userDTOs.add(userDTO);
//		}
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, userDTOs, null));
	}
	
	@GetMapping("/user")
	public ResponseEntity<BillShareResponse> getUserInfo(@RequestHeader(value = "Authorization") String token){
		UserEntity user = userService.findUser(token);
		UserDTO userDTO = userMapper.convertEntityToDTO(user);
		//userMapper.convertEntityToDTO(user, userDTO);
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, userDTO, null));
	}
	
	
	@GetMapping("/search")
	public ResponseEntity<BillShareResponse> searchUser(@RequestParam String email) {
		List<UserEntity> users = userService.searchUsers(email);
		List<UserDTO> userDTOs = users.stream().map(user -> userMapper.convertEntityToDTO(user)).collect(Collectors.toList());
//		for(UserEntity user : users) {
//			UserDTO userDTO = new UserDTO();
//			userMapper.convertEntityToDTO(user, userDTO);
//			userDTOs.add(userDTO);
//		}
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, userDTOs, null));
	}
	
	
	@PostMapping
	public ResponseEntity<BillShareResponse> registerNewUser(@Valid @RequestBody CreateUserForm form) {
		UserEntity user = userService.createUser(form);
		UserDTO userDTO = userMapper.convertEntityToDTO(user);
//		userMapper.convertEntityToDTO(user, userDTO);
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, userDTO, null));
	}
	
	@PutMapping
	public ResponseEntity<BillShareResponse> updateExistingUser(@Valid @RequestBody UpdateUserForm form, @RequestHeader(value = "Authorization") String token) {
		UserEntity user = userService.updateUser(form, token);
		UserDTO userDTO = userMapper.convertEntityToDTO(user);
//		userMapper.convertEntityToDTO(user, userDTO);
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, userDTO, null));
	}
	
}
