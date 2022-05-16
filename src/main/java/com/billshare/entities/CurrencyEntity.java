package com.billshare.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
public class CurrencyEntity {
	
	@Id
	@GeneratedValue
	public Long currencyId;
	
	public String currencyName;
	
	public String currencyCode;
	
	public Timestamp creationDate;
	
	public Timestamp lastUpdateDate;
	
	public CurrencyEntity() {
		
	}

	public CurrencyEntity(Long currencyId, String currencyName, String currencyCode,
			Timestamp creationDate, Timestamp lastUpdateDate) {
		super();
		this.currencyId = currencyId;
		this.currencyName = currencyName;
		this.currencyCode = currencyCode;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
