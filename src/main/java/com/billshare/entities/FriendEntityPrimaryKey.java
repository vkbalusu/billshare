package com.billshare.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FriendEntityPrimaryKey implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "requester_id")
    public Long requesterId;

    @Column(name = "addressee_id")
    public Long addresseeId;
    
    public FriendEntityPrimaryKey() {
    	
    }
    
    
    public FriendEntityPrimaryKey(Long requesterId, Long addresseeId) {
		super();
		this.requesterId = requesterId;
		this.addresseeId = addresseeId;
	}

	public Long getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(Long requesterId) {
		this.requesterId = requesterId;
	}

	public Long getAddresseeId() {
		return addresseeId;
	}

	public void setAddresseeId(Long addresseeId) {
		this.addresseeId = addresseeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addresseeId, requesterId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendEntityPrimaryKey other = (FriendEntityPrimaryKey) obj;
		return Objects.equals(addresseeId, other.addresseeId) && Objects.equals(requesterId, other.requesterId);
	}

    
}