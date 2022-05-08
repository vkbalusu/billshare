package com.billshare.models.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.billshare.utils.ValidationMessages;

public class CreateUserForm {
	
	@NotBlank(message = ValidationMessages.FIRST_NAME_NOT_NULL) @Size(max = 30, message = ValidationMessages.FIRST_NAME_MAX_LEN)
	private String firstName;
	
	@NotBlank(message = ValidationMessages.LAST_NAME_NOT_NULL) @Size(max = 30, message = ValidationMessages.LAST_NAME_MAX_LEN)
	private String lastName;
	
	private String nickName;
	
	@NotBlank(message = ValidationMessages.EMAIL_NOT_NULL) @Email (message = ValidationMessages.EMAIL_NOT_VALID)
	private String email;
	
	@NotBlank (message = ValidationMessages.PASSWORD_NOT_NULL) @Size(min = 8, max = 20, message = ValidationMessages.PASSWORD_LEN)
	private String password;
	private String avatar;
	//todo : validate phone number with regex
	private String phone;
	
	public CreateUserForm(String firstName, String lastName, String nickname, String email, String password, String avatar,
			String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickname;
		this.email = email;
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

	public void setNickName(String niceName) {
		this.nickName = niceName;
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

}
