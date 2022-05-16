package com.billshare.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IndebtEntityPrimaryKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "bill_id")
	public Long billId;
	
	@Column(name = "debtor_id")
	public Long debtorId;
	
	public IndebtEntityPrimaryKey() {
		
	}

	public IndebtEntityPrimaryKey(Long billId, Long debtorId) {
		super();
		this.billId = billId;
		this.debtorId = debtorId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Long getDebtorId() {
		return debtorId;
	}

	public void setDebtorId(Long debtorId) {
		this.debtorId = debtorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(billId, debtorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndebtEntityPrimaryKey other = (IndebtEntityPrimaryKey) obj;
		return Objects.equals(billId, other.billId) && Objects.equals(debtorId, other.debtorId);
	}
	
}
