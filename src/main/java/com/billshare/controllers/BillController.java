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
import com.billshare.mappers.BillDTOMapper;
import com.billshare.models.dtos.BillInfoDTO;
import com.billshare.models.dtos.BillMetaDTO;
import com.billshare.models.forms.CreateBillForm;
import com.billshare.models.responses.BillShareResponse;
import com.billshare.services.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {
	
	@Autowired
	BillService billService;
	
	@Autowired
	BillDTOMapper billDTOMapper;
	
	@GetMapping
	public ResponseEntity<BillShareResponse> getUserInvolvedBills(@RequestHeader("Authorization") String token){
		List<BillEntity> bills = billService.getUserInvolvedBills(token);
		List<BillMetaDTO> billMetaDto = bills.stream().map(bill -> billDTOMapper.convertEntitytoMetaDTO(bill)).collect(Collectors.toList());
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, billMetaDto, null));
	}
	
	@GetMapping("/{billId}")
	public ResponseEntity<BillShareResponse> getBillInformation(@Valid @NotBlank @PathVariable Long billId){
		BillEntity bill = billService.getBillInformation(billId);
		BillInfoDTO billDTO = billDTOMapper.convertEntityToDTO(bill);
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, billDTO, null));
	}
	
	@PostMapping
	public ResponseEntity<BillShareResponse> createBill(@RequestHeader("Authorization") String token, @Valid @RequestBody CreateBillForm createBillForm){
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, billService.createBill(token, createBillForm), null));
	}

}
