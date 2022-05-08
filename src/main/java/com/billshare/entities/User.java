package com.billshare.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.billshare.models.forms.CreateUserForm;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	
//	@Autowired
//	BCryptPasswordEncoder encoder;
	
	@Id
	@GeneratedValue
	public Long userId;
	
	public String firstName;
	
	public String lastName;
	
	@Column(name = "nickname")
	public String nickName;
	
	public String email;
	
	//exclude in GET API responses
	@JsonIgnore
	public String password;
	
	public String avatar;
	
	public String phone;
	
	public Timestamp creationDate;
	
	public Timestamp lastUpdateDate;
	
	public User() {
		
	}
	
	public User(Long user_id, String firstName, String lastName, String nickName, String email, String password,
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
	
	public User(CreateUserForm form) {
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
	
}
