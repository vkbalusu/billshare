package com.billshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billshare.entities.CurrencyEntity;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long>{
	
	public CurrencyEntity getByCurrencyCode(String currencyCode);
}
