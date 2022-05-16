package com.billshare.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billshare.entities.UserEntity;
import com.billshare.exceptions.AuthenticationException;
import com.billshare.exceptions.RecordAlreadyExistsException;
import com.billshare.exceptions.RecordNotFoundException;
import com.billshare.mappers.UserUpdateFormMapper;
import com.billshare.models.forms.CreateUserForm;
import com.billshare.models.forms.UpdateUserForm;
import com.billshare.repositories.UserRepository;
import com.billshare.utils.AuthenticationUtils;
import com.billshare.utils.ExceptionMessages;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private UserUpdateFormMapper userMapper;
	
	@Autowired
	private AuthenticationUtils authenticationUtils;
	
	public List<UserEntity> getAllUsers(){
		return userRepository.findAll();
	}
	
	public UserEntity findUser(String token) {
		if(!token.startsWith("Bearer "))
			throw new AuthenticationException(ExceptionMessages.NO_AUTH_TOKEN);
		return findUserByEmail(authenticationUtils.extractUsername(token.substring(7)));
	}
	
	public List<UserEntity> searchUsers(String email){
		return userRepository.findByEmailStartsWith(email);
	}
	
	public UserEntity createUser(CreateUserForm signUpForm){
		UserEntity user = userRepository.findByEmail(signUpForm.getEmail());
		if(user != null) {
			throw new RecordAlreadyExistsException(ExceptionMessages.USER_ALREADY_EXISTS);
		}
		userRepository.save(new UserEntity(signUpForm));
		return userRepository.findByEmail(signUpForm.getEmail());
	}
	
	public UserEntity updateUser(UpdateUserForm updateUserForm, String token) {
		
		if(! token.startsWith("Bearer "))
			throw new AuthenticationException(ExceptionMessages.NO_AUTH_TOKEN);
		UserEntity user =  userRepository.findByEmail(authenticationUtils.extractUsername(token.substring(7)));
		if(user == null) {
			throw new RecordNotFoundException(ExceptionMessages.USER_NOT_FOUND);
		}
//		user = userMapper.mapUserDetails(updateUserForm);
		userMapper.mapUserDetails(updateUserForm, user);
		user.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		userRepository.save(user);
		return user;
	}

	//used in bills service
	public UserEntity findUserByEmail(String email) {
		UserEntity user = userRepository.findByEmail(email);
		if(user == null)
			throw new RecordNotFoundException(ExceptionMessages.USER_NOT_FOUND);
		return user;
	}
}
