package com.billshare.models.dtos;

public class FriendDTO {
	
    public UserDTO requester;

    public UserDTO addressee;
    
    public String status;
    
    public UserDTO getRequester() {
		return requester;
	}

	public void setRequester(UserDTO requester) {
		this.requester = requester;
	}

	public UserDTO getAddressee() {
		return addressee;
	}

	public void setAddressee(UserDTO addressee) {
		this.addressee = addressee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
