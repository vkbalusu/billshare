package com.billshare.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillMetaDTO {
	
	public Long billId;
	
	public String description;
	
	public BigDecimal amount;
	
	public String currency;
	
	//public String status;
	public boolean overDue;
	
	public String receipt;
	
	public LocalDate dueDate;
	
	public String createdBy;
    
    public String creationDate;
    
    
    public BillMetaDTO() {
    	
    }
    
	public BillMetaDTO(Long billId, String description, BigDecimal amount, String currency, boolean overDue, String receipt, LocalDate dueDate,
			String createdBy, String creationDate) {
		super();
		this.billId = billId;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.overDue = overDue;
		this.receipt = receipt;
		this.dueDate = dueDate;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
	}
	
	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
	
	
	public String getReceipt() {
		return receipt;
	}
	
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isOverDue() {
		return overDue;
	}

	public void setOverDue(boolean overDue) {
		this.overDue = overDue;
	}

}
