package com.billshare.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billshare.entities.UserEntity;
import com.billshare.mappers.UserDTOMapper;
import com.billshare.models.dtos.UserDTO;
import com.billshare.models.responses.BillShareResponse;
import com.billshare.services.FriendService;

@RestController
@RequestMapping("/friends")
public class FriendController {
	
	@Autowired
	public FriendService friendService;
	
	@Autowired
	public UserDTOMapper userDTOMapper;
	
	@GetMapping
	public ResponseEntity<BillShareResponse> getFriends(@RequestHeader(value = "Authorization") String token, @RequestParam @NotBlank String status){
		List<UserEntity> friends = friendService.getAllFriendsofUser(token, status.toUpperCase());
		List<UserDTO> friendDTOs = friends.stream().map(friend -> userDTOMapper.convertEntityToDTO(friend)).collect(Collectors.toList());
//		for(UserEntity friendEntity : friends) {
//			UserDTO friendDTO = new UserDTO();
//			userDTOMapper.convertEntityToDTO(friendEntity, friendDTO);
//			friendDTOs.add(friendDTO);
//		}
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, friendDTOs, null));
	}
	
	@PostMapping
	public ResponseEntity<BillShareResponse> sendRequest(@RequestHeader(value = "Authorization") String token, @RequestParam @Email String addressee){
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, friendService.sendRequest(token, addressee), null));
	}
	
	@PutMapping
	public ResponseEntity<BillShareResponse> approveReuqest(@RequestHeader(value = "Authorization") String token, @RequestParam @Email String requester){
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, friendService.approveRequest(token, requester), null));
	} 
	
}
