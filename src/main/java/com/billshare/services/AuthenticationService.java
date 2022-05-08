package com.billshare.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.billshare.exceptions.RecordNotFoundException;
import com.billshare.repositories.UserRepository;
import com.billshare.utils.ExceptionMessages;

@Service
public class AuthenticationService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.billshare.entities.User user = userRepository.findByEmail(username);
		if(user == null)
			throw new RecordNotFoundException(ExceptionMessages.USER_NOT_FOUND);
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

}
