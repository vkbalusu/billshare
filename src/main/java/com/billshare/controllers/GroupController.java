package com.billshare.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billshare.entities.BillEntity;
import com.billshare.entities.GroupEntity;
import com.billshare.mappers.BillDTOMapper;
import com.billshare.mappers.GroupDTOMapper;
import com.billshare.models.dtos.BillMetaDTO;
import com.billshare.models.dtos.GroupDTO;
import com.billshare.models.forms.CreateGroupForm;
import com.billshare.models.responses.BillShareResponse;
import com.billshare.services.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupController {
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	BillDTOMapper billDTOMapper;
	
	@Autowired
	GroupDTOMapper groupDTOMapper;
	
	@GetMapping
	public ResponseEntity<BillShareResponse> getUserInvolvedGroups(@RequestHeader("Authorization") String token){
		List<GroupEntity> groups = groupService.getUserInvolvedGroups(token);
		List<GroupDTO> groupDTOs = groups.stream().map(group -> groupDTOMapper.convertEntityToDTO(group)).collect(Collectors.toList());
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, groupDTOs, null));
	}
	
	
	
	@GetMapping("{groupId}/bills")
	public ResponseEntity<BillShareResponse> getBillsInAGroup(@Valid @NotBlank @PathVariable Long groupId){
		List<BillEntity> bills = groupService.getBillsInAGroup(groupId);
		List<BillMetaDTO> billMetaDto = bills.stream().map(bill -> billDTOMapper.convertEntitytoMetaDTO(bill)).collect(Collectors.toList());
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, billMetaDto, null));
	}
	
	@PostMapping
	public ResponseEntity<BillShareResponse> createGroup(@RequestHeader("Authorization") String token, @Valid @RequestBody CreateGroupForm createGroupForm){
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.CREATED, groupService.createGroup(token, createGroupForm) , null));
	}

}
