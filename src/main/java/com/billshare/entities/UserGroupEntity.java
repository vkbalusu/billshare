package com.billshare.entities;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "user_groups")
public class UserGroupEntity {
	
	@EmbeddedId
	public UserGroupEntityPrimaryKey id;
	
	@ManyToOne
	@MapsId("groupId")
	@JoinColumn(name = "group_id")
	public GroupEntity group;
	
	
	@ManyToOne
	@MapsId("memberId")
	@JoinColumn(name = "member_id")
	public UserEntity member;
	
	public Integer status;
	
	public Timestamp lastUpdateDate;
	
	
	public UserGroupEntity() {
		
	}
	
	public UserGroupEntity(UserGroupEntityPrimaryKey id, GroupEntity group, UserEntity member, Integer status,
			Timestamp lastUpdateDate) {
		super();
		this.id = id;
		this.group = group;
		this.member = member;
		this.status = status;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public UserGroupEntity(GroupEntity group, UserEntity member) {
		this.id = new UserGroupEntityPrimaryKey(group.getGroupId(), member.getUserId());
		this.group = group;
		this.member = member;
		this.status = 1; //member is active
		this.lastUpdateDate = new Timestamp(System.currentTimeMillis());
	}

	public UserGroupEntityPrimaryKey getId() {
		return id;
	}

	public void setId(UserGroupEntityPrimaryKey id) {
		this.id = id;
	}

	public GroupEntity getGroup() {
		return group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}

	public UserEntity getMember() {
		return member;
	}

	public void setMember(UserEntity member) {
		this.member = member;
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
