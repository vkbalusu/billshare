package com.billshare.entities;

import java.sql.Timestamp;
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

import com.billshare.models.forms.CreateGroupForm;

@Entity
@Table(name = "groups")
public class GroupEntity {
	
	@Id
	@GeneratedValue
	public Long groupId;
	
	public String title;
	
	public String avatar;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	public UserEntity createdBy;
	
	public Timestamp creationDate;
	
	@ManyToOne
	@JoinColumn(name = "last_update_by")
	public UserEntity lastUpdateBy;
	
	public Timestamp lastUpdateDate;
	
	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<UserGroupEntity> members;
	
	public GroupEntity() {
		
	}

	public GroupEntity(Long groupId, String title, String avatar, UserEntity createdBy, Timestamp creationDate, UserEntity lastUpdateBy,
			Timestamp lastUpdateDate) {
		super();
		this.groupId = groupId;
		this.title = title;
		this.avatar = avatar;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.lastUpdateBy = lastUpdateBy;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public GroupEntity(CreateGroupForm createGroupForm) {
		this.title = createGroupForm.getTitle();
		this.avatar = createGroupForm.getAvatar();
		this.creationDate = new Timestamp(System.currentTimeMillis());
		this.lastUpdateDate = new Timestamp(System.currentTimeMillis());
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

	public List<UserGroupEntity> getMembers() {
		return members;
	}

	public void setMembers(List<UserGroupEntity> members) {
		this.members = members;
	}

}
