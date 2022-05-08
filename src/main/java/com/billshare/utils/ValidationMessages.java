package com.billshare.utils;

public class ValidationMessages {
	
	
//	public static final String notBlank(String string) {
//		return string + " can not be empty";
//	}
//	
//	public static final String maxLen(String string, Integer len) {
//		return string + " can not be longer than " + len.toString();
//	}
	
	//user sign up form
	public static final String FIRST_NAME_NOT_NULL = "First name can not be empty";
	public static final String FIRST_NAME_MAX_LEN = "First name can not be longer than 30 characters";
	public static final String LAST_NAME_NOT_NULL = "Last name can not be empty";
	public static final String LAST_NAME_MAX_LEN = "Last name can not be longer than 30 characters";
	public static final String EMAIL_NOT_NULL = "Email can not be empty";
	public static final String EMAIL_NOT_VALID = "Not a valid email";
	public static final String PASSWORD_NOT_NULL = "Password can not be empty";
	public static final String PASSWORD_LEN = "Password must between 8 and 20 characters in length";
}
