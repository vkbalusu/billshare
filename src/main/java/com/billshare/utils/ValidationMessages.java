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
	
	//create bill form
	public static final String BILL_DESC_NOT_NULL = "Bill description can not be empty";
	public static final String BILL_DESC_MAX_LEN = "Bill description can not be longer than 50 characters";
	public static final String BILL_AMNT_NOT_NULL = "Bill amount can not be null";
	public static final String BILL_AMNT_POSITIVE = "Bill amount shoule be positive";
	public static final String CURRENCY_NOT_NULL = "Currency can not be empty";
	public static final String BILL_DUE_DATE_NOT_NULL = "Due date can not be empty";
	public static final String DEBTORS_NOT_EMPTY = "List of debtors can not be empty";
	public static final String DEBTOR_EMAIL_NOT_NULL = "Debtor email can not be empty";
	public static final String DEBT_AMOUNT_POSITIVE = "Indebt amount should be positive";
	
	
	//currencies
	public static final String CURR_CODE_LEN = "Currency code should be of 3 characters";
	
	//create group form
	public static final String GROUP_TITLE_NOT_NULL = "Group title can not be empty";
	public static final String GROUP_TITLE_MAX_LEN = "Group title can not be longer than 50 characters";
	public static final String GROUP_MEMBERS_NOT_EMPTY = "List of members can not be empty";
	
	
	
	
}
