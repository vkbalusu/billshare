package com.billshare.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billshare.entities.CurrencyEntity;
import com.billshare.exceptions.RecordNotFoundException;
import com.billshare.mappers.CurrencyDTOMapper;
import com.billshare.models.dtos.CurrencyDTO;
import com.billshare.models.responses.BillShareResponse;
import com.billshare.services.CurrencyService;
import com.billshare.utils.ExceptionMessages;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired CurrencyDTOMapper currencyDTOMapper;
	
	@GetMapping
	public ResponseEntity<BillShareResponse> getAllCurrencies(){
		List<CurrencyEntity> currencies = currencyService.getAllCurrencies();
		List<CurrencyDTO> currencyDTOs = currencies.stream().map(currency -> currencyDTOMapper.convertEntityToDTO(currency)).collect(Collectors.toList());
//		for(CurrencyEntity currencyEntity : currencies) {
//			CurrencyDTO currencyDTO = new CurrencyDTO();
//			currencyDTOMapper.convertEntityToDTO(currencyEntity, currencyDTO);
//			currencyDTOs.add(currencyDTO);
//		}
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, currencyDTOs, null));
	}
	
	@GetMapping("/{currencyCode}")
	public ResponseEntity<BillShareResponse> getCurrencyByCode(@PathVariable String currencyCode){
		CurrencyEntity currencyEntity = currencyService.getCurrencyByCode(currencyCode);
		if(currencyEntity == null) {
			throw new RecordNotFoundException(ExceptionMessages.NO_CURRENCY_FOUND);
		}
		CurrencyDTO currencyDTO = currencyDTOMapper.convertEntityToDTO(currencyEntity);
		//currencyDTOMapper.convertEntityToDTO(currencyEntity, currencyDTO);
		return ResponseEntity.ok(new BillShareResponse(HttpStatus.OK, currencyDTO, null));
	}
	
}
