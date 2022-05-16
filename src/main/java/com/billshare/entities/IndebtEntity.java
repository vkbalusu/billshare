package com.billshare.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "indebts")
public class IndebtEntity {
	
	@EmbeddedId
	public IndebtEntityPrimaryKey id;
	
	@ManyToOne
    @MapsId("billId")
    @JoinColumn(name = "bill_id")
	public BillEntity bill;
	
	@ManyToOne
    @MapsId("debtorId")
    @JoinColumn(name = "debtor_id")
	public UserEntity debtor;
	
	public BigDecimal amount;
	
	public Integer status;
	
	public Timestamp lastUpdateDate;
	
	public IndebtEntity() {
	}

	public IndebtEntity(IndebtEntityPrimaryKey id, BillEntity bill, UserEntity debtor, BigDecimal amount,
			Integer status, Timestamp lastUpdateDate) {
		super();
		this.id = id;
		this.bill = bill;
		this.debtor = debtor;
		this.amount = amount;
		this.status = status;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public IndebtEntity(UserEntity debtor, BillEntity bill, BigDecimal amount) {
		this.id = new IndebtEntityPrimaryKey(bill.getBillId(), debtor.getUserId());
		this.bill = bill;
		this.debtor = debtor;
		this.amount = amount;
		this.status = 0; // new indebt record
		this.lastUpdateDate = new Timestamp(System.currentTimeMillis());
	}

	public IndebtEntityPrimaryKey getId() {
		return id;
	}

	public void setId(IndebtEntityPrimaryKey id) {
		this.id = id;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	public UserEntity getDebtor() {
		return debtor;
	}

	public void setDebtor(UserEntity debtor) {
		this.debtor = debtor;
	}

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
