package com.billshare.models.dtos;

import java.sql.Timestamp;

public class GroupDTO {

	public Long groupId;
	
	public String title;
	
	public String avatar;
	
	public String createdBy;
	
	public Timestamp creationDate;

	public GroupDTO(Long groupId, String title, String avatar, String createdBy, Timestamp creationDate) {
		super();
		this.groupId = groupId;
		this.title = title;
		this.avatar = avatar;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}
