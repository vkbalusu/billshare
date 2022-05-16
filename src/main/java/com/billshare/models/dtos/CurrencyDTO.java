package com.billshare.models.dtos;

public class CurrencyDTO {
	
	public String currencyName;
	
	public String currencyCode;
	
	public CurrencyDTO() {
		
	}

	public CurrencyDTO(String currencyName, String currencyCode) {
		super();
		this.currencyName = currencyName;
		this.currencyCode = currencyCode;
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
}
