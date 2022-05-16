package com.billshare.models.forms;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.billshare.utils.ValidationMessages;

public class CreateBillForm {
	
	@NotBlank(message = ValidationMessages.BILL_DESC_NOT_NULL) @Size(max = 50, message = ValidationMessages.BILL_DESC_MAX_LEN)
	public String description;
	
	@NotNull(message = ValidationMessages.BILL_AMNT_NOT_NULL) @DecimalMin(value = "0.0", inclusive = false, message = ValidationMessages.BILL_AMNT_POSITIVE)
	public BigDecimal amount;
	
	@NotBlank(message = ValidationMessages.CURRENCY_NOT_NULL)
	public String currencyCode;
	
	public String receipt;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate dueDate;
	
	@NotEmpty(message = ValidationMessages.DEBTORS_NOT_EMPTY)
	public List<@Valid CreateIndebtForm> debtorsInfo;
	
	public Long groupId;

	public CreateBillForm(String description, BigDecimal amount, String currencyCode, String receipt, LocalDate dueDate, 
			List<CreateIndebtForm> debtorsInfo, Long groupId) {
		super();
		this.description = description;
		this.amount = amount;
		this.currencyCode = currencyCode;
		this.receipt = receipt;
		this.dueDate = dueDate;
		this.debtorsInfo = debtorsInfo;
		this.groupId = groupId;
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

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

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

	public List<CreateIndebtForm> getDebtorsInfo() {
		return debtorsInfo;
	}

	public void setDebtorsInfo(List<CreateIndebtForm> debtorsInfo) {
		this.debtorsInfo = debtorsInfo;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
}
