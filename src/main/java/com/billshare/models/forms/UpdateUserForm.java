package com.billshare.models.forms;

import javax.validation.constraints.Size;

import com.billshare.utils.ValidationMessages;

public class UpdateUserForm {
	@Size(max = 30, message = ValidationMessages.FIRST_NAME_MAX_LEN)
	private String firstName;
	
	@Size(max = 30, message = ValidationMessages.LAST_NAME_MAX_LEN)
	private String lastName;
	
	private String nickName;
	
	@Size(min = 8, max = 20, message = ValidationMessages.PASSWORD_LEN)
	private String password;
	private String avatar;
	//todo : validate phone number with regex
	private String phone;
	
	public UpdateUserForm(String firstName, String lastName, String nickname, String email, String password, String avatar, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickname;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
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

}
