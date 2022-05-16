package com.billshare.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billshare.entities.BillEntity;
import com.billshare.entities.GroupEntity;
import com.billshare.entities.UserEntity;
import com.billshare.entities.UserGroupEntity;
import com.billshare.exceptions.BillShareException;
import com.billshare.exceptions.RecordNotFoundException;
import com.billshare.models.forms.CreateGroupForm;
import com.billshare.repositories.BillRepository;
import com.billshare.repositories.GroupRepository;
import com.billshare.utils.BillShareMessages;
import com.billshare.utils.ExceptionMessages;

@Service
public class GroupService {
	
	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FriendService friendService;
	
	@Autowired
	BillRepository billRepository;
	
	public List<GroupEntity> getUserInvolvedGroups(String token){
		UserEntity user = userService.findUser(token);
		return user.getGroups().stream().map(usergroup -> usergroup.getGroup()).collect(Collectors.toList());
	}
	
	
	public List<BillEntity> getBillsInAGroup(Long groupId){
		return billRepository.findByGroup(getGroupById(groupId));
	}

	public GroupEntity getGroupById(Long groupId) {
		GroupEntity group = groupRepository.getById(groupId);
		if(group == null)
			throw new RecordNotFoundException(ExceptionMessages.NO_GROUP_FOUND);
		return group;
	}

	public String createGroup(String token, @Valid CreateGroupForm createGroupForm) {
		
		UserEntity creator = userService.findUser(token);
		
		GroupEntity group = new GroupEntity(createGroupForm);
		group.setCreatedBy(creator);
		group.setLastUpdateBy(creator);
		
		List<UserEntity> friends = friendService.getAllFriendsofUser(creator.getEmail());
		
		List<UserGroupEntity> groupMembers = new ArrayList<>();
		//members validation
		for(String memberEmail : createGroupForm.getMembers()) {
			//skip owner if present in pay load
			if(memberEmail.equals(creator.getEmail()))
				continue;
			UserEntity member = userService.findUserByEmail(memberEmail);
			if(friends.contains(member) == false)
				throw new BillShareException(member.firstName + " " + member.getLastName() + " is not in your friends list. Can not create a group.");
			//linking group and member to each user group record
			groupMembers.add(new UserGroupEntity(group, member));
		}
		//add creater by default
		groupMembers.add(new UserGroupEntity(group, creator));
		
		group.setMembers(groupMembers);
		groupRepository.save(group);
		return BillShareMessages.GROUP_CREATED;
	}

}
