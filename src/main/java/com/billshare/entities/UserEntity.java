package com.billshare.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.billshare.models.forms.CreateUserForm;

@Entity
@Table(name="users")
public class UserEntity {
		
	@Id
	@GeneratedValue
	public Long userId;
	
	public String firstName;
	
	public String lastName;
	
	@Column(name = "nickname")
	public String nickName;
	
	public String email;
	
	public String password;
	
	public String avatar;
	
	public String phone;
	
	public Timestamp creationDate;
	
	public Timestamp lastUpdateDate;
	
	@OneToMany(mappedBy = "requester", fetch = FetchType.LAZY)
	public List<FriendEntity> friends;
				
	@OneToMany(mappedBy = "addressee", fetch = FetchType.LAZY)
	public List<FriendEntity> friendOf;
	
	@OneToMany(mappedBy = "debtor", fetch = FetchType.LAZY)
	public List<IndebtEntity> indebtBills;
	
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
	public List<BillEntity> createdBills;
	
	@OneToMany(mappedBy = "lastUpdateBy", fetch = FetchType.LAZY)
	public List<BillEntity> lastUpdatedBills;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	public List<UserGroupEntity> groups;
	
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
	public List<GroupEntity> createdGroups;
	
	@OneToMany(mappedBy = "lastUpdateBy", fetch = FetchType.LAZY)
	public List<BillEntity> lastUpdatedGroups;
	
	
	public UserEntity() {
		
	}
	
	public UserEntity(Long user_id, String firstName, String lastName, String nickName, String email, String password,
			String avatar, String phone, Timestamp creationDate, Timestamp lastUpdateDate) {
		super();
		this.userId = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
		this.avatar = avatar;
		this.phone = phone;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public UserEntity(CreateUserForm form) {
		this.firstName = form.getFirstName();
		this.lastName = form.getLastName();
		this.nickName = form.getNickName();
		this.email = form.getEmail();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(form.getPassword());
		this.avatar = form.getAvatar();
		this.phone = form.getPhone();
		this.creationDate = new Timestamp(System.currentTimeMillis());
		this.lastUpdateDate = new Timestamp(System.currentTimeMillis());
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public List<FriendEntity> getFriends() {
		return friends;
	}

	public void setFriends(List<FriendEntity> friends) {
		this.friends = friends;
	}

	public List<FriendEntity> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(List<FriendEntity> friendOf) {
		this.friendOf = friendOf;
	}

	public List<BillEntity> getCreatedBills() {
		return createdBills;
	}

	public void setCreatedBills(List<BillEntity> createdBills) {
		this.createdBills = createdBills;
	}

	public List<BillEntity> getLastUpdatedBills() {
		return lastUpdatedBills;
	}

	public void setLastUpdatedBills(List<BillEntity> lastUpdatedBills) {
		this.lastUpdatedBills = lastUpdatedBills;
	}

	public List<IndebtEntity> getIndebtBills() {
		return indebtBills;
	}

	public void setIndebtBills(List<IndebtEntity> indebtBills) {
		this.indebtBills = indebtBills;
	}

	public List<UserGroupEntity> getGroups() {
		return groups;
	}

	public void setGroups(List<UserGroupEntity> groups) {
		this.groups = groups;
	}

	public List<GroupEntity> getCreatedGroups() {
		return createdGroups;
	}

	public void setCreatedGroups(List<GroupEntity> createdGroups) {
		this.createdGroups = createdGroups;
	}

	public List<BillEntity> getLastUpdatedGroups() {
		return lastUpdatedGroups;
	}

	public void setLastUpdatedGroups(List<BillEntity> lastUpdatedGroups) {
		this.lastUpdatedGroups = lastUpdatedGroups;
	}
	
}
