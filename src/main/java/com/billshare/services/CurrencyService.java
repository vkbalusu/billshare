package com.billshare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billshare.entities.CurrencyEntity;
import com.billshare.repositories.CurrencyRepository;

@Service
public class CurrencyService {
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	public CurrencyEntity getCurrencyByCode(String curencyCode) {
		return currencyRepository.getByCurrencyCode(curencyCode);
	}

	public List<CurrencyEntity> getAllCurrencies() {
		return currencyRepository.findAll();
	}

}
