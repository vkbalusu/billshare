package com.billshare.models.forms;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.billshare.utils.ValidationMessages;

public class CreateGroupForm {
	
	@NotBlank(message = ValidationMessages.GROUP_TITLE_NOT_NULL) @Size(max = 50, message = ValidationMessages.GROUP_TITLE_MAX_LEN)
	public String title;
	
	public String avatar;
	
	@NotEmpty(message = ValidationMessages.GROUP_MEMBERS_NOT_EMPTY)
	public List<String> members;

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

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

}
