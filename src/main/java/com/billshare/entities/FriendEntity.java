package com.billshare.entities;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="friend_requests")
public class FriendEntity {
	
	@EmbeddedId
	public FriendEntityPrimaryKey id;
	
	@ManyToOne
    @MapsId("requesterId")
    @JoinColumn(name = "requester_id")
    public UserEntity requester;

    @ManyToOne
    @MapsId("addresseeId")
    @JoinColumn(name = "addressee_id")
    public UserEntity addressee;
    
    public String status;
    
    public Timestamp creationDate;
	
	public Timestamp lastUpdateDate;
	
	
	public FriendEntity() {
		
	}

	public FriendEntity(FriendEntityPrimaryKey id, UserEntity requester, UserEntity addressee, String status, Timestamp creationDate,
			Timestamp lastUpdateDate) {
		super();
		this.id = id;
		this.requester = requester;
		this.addressee = addressee;
		this.status = status;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public FriendEntity(UserEntity requester, UserEntity addressee, String status) {
		super();
		this.id = new FriendEntityPrimaryKey(requester.getUserId(), addressee.getUserId());
		this.requester = requester;
		this.addressee = addressee;
		this.status = status;
		this.creationDate = new Timestamp(System.currentTimeMillis());
		this.lastUpdateDate = new Timestamp(System.currentTimeMillis());
	}
	

	public FriendEntityPrimaryKey getId() {
		return id;
	}

	public void setId(FriendEntityPrimaryKey id) {
		this.id = id;
	}

	public UserEntity getRequester() {
		return requester;
	}

	public void setRequester(UserEntity requester) {
		this.requester = requester;
	}

	public UserEntity getAddressee() {
		return addressee;
	}

	public void setAddressee(UserEntity addressee) {
		this.addressee = addressee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
