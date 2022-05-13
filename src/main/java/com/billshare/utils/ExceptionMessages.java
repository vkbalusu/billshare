package com.billshare.utils;

public class ExceptionMessages {
	
	public static final String BAD_DATA = "Inconsistent data. Please contact admin for more details";
	
	//user management
	public static final String USER_NOT_FOUND = "No user exists with the email";
	public static final String USER_ALREADY_EXISTS = "User already exists";
	public static final String IMPROPER_DATA = "Could not parse input data";
	public static final String ERROR_IN_PROCESSING = "Error processing the request";
	
	//authentication
	public static final String UNAUTHORISED_USER = "Invalid User name or password";
	public static final String NO_AUTH_TOKEN = "No or invalid authorization header";
	
	//friend requests
	public static final String SELF_REQUEST = "Can not send/approve a freind request to yourself!";
	public static final String ALREADY_A_FRIEND = "User is already in your friends list. Can not send (or) approve a new request";
	public static final String DUPLICATE_REQUEST = "There is an existing friend request. Can not send (or) approve a new request";
	public static final String YOUR_APPROVAL_PENDING = "There is a friend request from the user. Please approve it to add friend";
	public static final String NO_PENDING_REQ = "There is no friend request from the user. Please send him a request to add friend";
}
