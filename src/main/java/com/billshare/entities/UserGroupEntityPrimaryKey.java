package com.billshare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserGroupEntityPrimaryKey implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "group_id")
	public Long groupId;
	
	@Column(name = "member_id")
	public Long memberId;
	
	
	public UserGroupEntityPrimaryKey() {
		
	}

	public UserGroupEntityPrimaryKey(Long groupId, Long memberId) {
		super();
		this.groupId = groupId;
		this.memberId = memberId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
}
