package com.billshare.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.billshare.models.forms.CreateBillForm;

@Entity
@Table(name = "bills")
public class BillEntity {
	
	@Id
	@GeneratedValue
	public Long billId;
	
	public String description;
	
	public BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "currency_id")
	public CurrencyEntity currency;
	
	public String receipt;
	
	public LocalDate dueDate;
	
	public String status;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	public UserEntity createdBy;
	
	@ManyToOne
	@JoinColumn(name = "group_id")
	public GroupEntity group;
	
    public Timestamp creationDate;
    
    @ManyToOne
	@JoinColumn(name = "last_update_by")
	public UserEntity lastUpdateBy;
    
	public Timestamp lastUpdateDate;
	
	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<IndebtEntity> debtors;
	
	public BillEntity() {
		
	}
	
	public BillEntity(Long billId, BigDecimal amount, CurrencyEntity currency, String description, String receipt, String status, UserEntity createdBy,
			GroupEntity group, Timestamp creationDate, LocalDate dueDate, UserEntity lastUpdateBy, Timestamp lastUpdateDate) {
		super();
		this.billId = billId;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.receipt = receipt;
		this.status = status;
		this.createdBy = createdBy;
		this.group = group;
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.lastUpdateBy = lastUpdateBy;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	//created by, group and last updated by set in bill create service
	public BillEntity(CreateBillForm createBillForm) {
		this.amount = createBillForm.getAmount();
//		this.currency = createBillForm.getCurrencyCode();
		this.description = createBillForm.getDescription();
		this.receipt = this.getReceipt();
		this.status = "CREATED";
		this.creationDate = new Timestamp(System.currentTimeMillis());
		this.dueDate = createBillForm.getDueDate();
		this.lastUpdateDate = new Timestamp(System.currentTimeMillis());
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public UserEntity getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(UserEntity lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
	}

	public List<IndebtEntity> getDebtors() {
		return debtors;
	}

	public void setDebtors(List<IndebtEntity> debtors) {
		this.debtors = debtors;
	}

	public GroupEntity getGroup() {
		return group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}

}
