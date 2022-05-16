package com.billshare.models.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class IndebtDTO {
	
	public UserDTO debtor;
	//public String user;
	
	public BigDecimal amount;
	
	public Integer status;
	
	public Timestamp lastUpdateDate;

	public IndebtDTO(UserDTO debtor, BigDecimal amount, Integer status, Timestamp lastUpdateDate) {
		super();
		this.debtor = debtor;
		this.amount = amount;
		this.status = status;
		this.lastUpdateDate = lastUpdateDate;
	}

	public UserDTO getDebtor() {
		return debtor;
	}

	public void setDebtor(UserDTO debtor) {
		this.debtor = debtor;
	}
	
//	public String getUser() {
//		return user;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
