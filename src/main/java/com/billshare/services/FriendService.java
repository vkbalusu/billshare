package com.billshare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billshare.entities.FriendEntity;
import com.billshare.entities.UserEntity;
import com.billshare.exceptions.AuthenticationException;
import com.billshare.exceptions.BillShareException;
import com.billshare.exceptions.RecordNotFoundException;
import com.billshare.repositories.FriendRepository;
import com.billshare.repositories.UserRepository;
import com.billshare.utils.AuthenticationUtils;
import com.billshare.utils.BillShareMessages;
import com.billshare.utils.ExceptionMessages;

@Service
public class FriendService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationUtils authenticationUtils;
	
	@Autowired
	private FriendRepository friendRepository; 

	public String sendRequest(String token, String addresseeEmail) {
		
		if(!token.startsWith("Bearer "))
			throw new AuthenticationException(ExceptionMessages.NO_AUTH_TOKEN);
		String requesterEmail = authenticationUtils.extractUsername(token.substring(7));
		if(addresseeEmail.equals(requesterEmail))
				throw new BillShareException(ExceptionMessages.SELF_REQUEST);
		UserEntity requestor =  userRepository.findByEmail(requesterEmail);
		UserEntity addressee =  userRepository.findByEmail(addresseeEmail);
		if(requestor == null || addressee == null)
			throw new RecordNotFoundException(ExceptionMessages.USER_NOT_FOUND);
		
		List<FriendEntity> exsitingRequests = friendRepository.findByRequesterAndAddressee(requestor, addressee);
		
		if(exsitingRequests != null && exsitingRequests.size() > 0) {
			if(exsitingRequests.size() > 1)
				throw new BillShareException(ExceptionMessages.BAD_DATA);
			if(exsitingRequests.get(0).getStatus().equals("APPROVED"))
				throw new BillShareException(ExceptionMessages.ALREADY_A_FRIEND);
			if(exsitingRequests.get(0).getStatus().equals("PENDING"))
				throw new BillShareException(ExceptionMessages.DUPLICATE_REQUEST);
		}
		exsitingRequests =  friendRepository.findByRequesterAndAddressee(addressee, requestor);
		
		if(exsitingRequests != null && exsitingRequests.size() > 0) {
			if(exsitingRequests.size() > 1)
				throw new BillShareException(ExceptionMessages.BAD_DATA);
			if(exsitingRequests.get(0).getStatus().equals("APPROVED"))
				throw new BillShareException(ExceptionMessages.ALREADY_A_FRIEND);
			if(exsitingRequests.get(0).getStatus().equals("PENDING"))
				throw new BillShareException(ExceptionMessages.YOUR_APPROVAL_PENDING);
		}
		
		FriendEntity friendEntity = new FriendEntity(requestor, addressee, "PENDING");
		friendRepository.save(friendEntity);
		return BillShareMessages.FRIEND_REQUEST_SENT;
	}
	
	public String approveRequest(String token, String requestorEmail) {
		
		if(!token.startsWith("Bearer "))
			throw new AuthenticationException(ExceptionMessages.NO_AUTH_TOKEN);
		
		String addresseeEmail = authenticationUtils.extractUsername(token.substring(7));
		
		if(requestorEmail.equals(addresseeEmail))
				throw new BillShareException(ExceptionMessages.SELF_REQUEST);
		
		UserEntity requestor =  userRepository.findByEmail(requestorEmail);
		UserEntity addressee =  userRepository.findByEmail(addresseeEmail);
	
		if(requestor == null || addressee == null)
			throw new RecordNotFoundException(ExceptionMessages.USER_NOT_FOUND);
		
		List<FriendEntity> exsitingRequests = friendRepository.findByRequesterAndAddressee(requestor, addressee);
		
		if(exsitingRequests == null || exsitingRequests.size() == 0)
			throw new BillShareException(ExceptionMessages.NO_PENDING_REQ);
		
		if(exsitingRequests.size() > 1)
			throw new BillShareException(ExceptionMessages.BAD_DATA);
		
		FriendEntity friendEntity = exsitingRequests.get(0);
		
		
		if(friendEntity.getStatus().equals("APPROVED"))
			throw new BillShareException(ExceptionMessages.ALREADY_A_FRIEND);
		
		friendEntity.setStatus("APPROVED");
		friendRepository.save(friendEntity);
		
//		the below doesn't work since those fileds are immutable for the entity
//		friendEntity.setAddressee(requestor);
//		friendEntity.setRequester(addressee);
		
		friendEntity = new FriendEntity(addressee, requestor, "APPROVED");
		friendRepository.save(friendEntity);
		return BillShareMessages.REQUEST_APPROVED;
	}
	
	

	public List<UserEntity> getAllFriendsofUser(String token, String status) {
		
		if(!token.startsWith("Bearer "))
			throw new RuntimeException(ExceptionMessages.NO_AUTH_TOKEN);
		UserEntity user =  userRepository.findByEmail(authenticationUtils.extractUsername(token.substring(7)));
		if(user == null)
			throw new RecordNotFoundException(ExceptionMessages.USER_NOT_FOUND);
		
		List<UserEntity> friends = friendRepository.findFriendsofUser(user, status);
		return friends;
	}

}
