package com.billshare.models.forms;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.billshare.utils.ValidationMessages;

public class CreateIndebtForm {

	@NotBlank(message = ValidationMessages.DEBTOR_EMAIL_NOT_NULL)
	public String email;
	
	@DecimalMin(value = "0.0", inclusive = false, message = ValidationMessages.DEBT_AMOUNT_POSITIVE)
	public BigDecimal amount;
	
	public CreateIndebtForm() {
		
	}

	public CreateIndebtForm(String email, BigDecimal amount) {
		super();
		this.email = email;
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
