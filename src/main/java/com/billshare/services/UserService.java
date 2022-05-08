package com.billshare.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billshare.entities.User;
import com.billshare.exceptions.RecordAlreadyExistsException;
import com.billshare.exceptions.RecordNotFoundException;
import com.billshare.models.forms.CreateUserForm;
import com.billshare.models.forms.UpdateUserForm;
import com.billshare.repositories.UserRepository;
import com.billshare.utils.AuthenticationUtils;
import com.billshare.utils.ExceptionMessages;
import com.billshare.utils.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AuthenticationUtils authenticationUtils;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User findUser(String token) {
		if(!token.startsWith("Bearer "))
			throw new RuntimeException(ExceptionMessages.NO_AUTH_TOKEN);
		User user =  userRepository.findByEmail(authenticationUtils.extractUsername(token.substring(7)));
		if(user == null)
			throw new RecordNotFoundException(ExceptionMessages.USER_NOT_FOUND);
		return user;
	}
	
	public User createUser(CreateUserForm signUpForm){
		User user = userRepository.findByEmail(signUpForm.getEmail());
		if(user != null) {
			throw new RecordAlreadyExistsException(ExceptionMessages.USER_ALREADY_EXISTS);
		}
		userRepository.save(new User(signUpForm));
		return userRepository.findByEmail(signUpForm.getEmail());
	}
	
	public User updateUser(UpdateUserForm updateUserForm, String token) {
		
		if(! token.startsWith("Bearer "))
			throw new RuntimeException(ExceptionMessages.NO_AUTH_TOKEN);
		User user =  userRepository.findByEmail(authenticationUtils.extractUsername(token.substring(7)));
		if(user == null) {
			throw new RecordNotFoundException(ExceptionMessages.USER_NOT_FOUND);
		}
		userMapper.mapUserDetails(updateUserForm, user);
		user.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		userRepository.save(user);
		return user;
	}
}
