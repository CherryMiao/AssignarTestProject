package com.testdata;

public class Testdata {
	public static final String URL = "https://mobile-staging.assignar.com";
	public static final String CLIENTID = "qatechtest";
	public static final String USERNAME = "fieldworkerqa";
	public static final String PASSWORD = "12345678";
	
	// DATE
	public static final String YEAR = "2019";
	public static final String MONTH = "12";
	public static final String DATE = "7";
	public static final String DAY = "Saturday";
	
	// TASK
	public static final String TASK = "Task QA Tech Test";
	
	//API
	public static final String LOGINURL = "https://auth-staging.assignar.com.au/login";
	public static final String REQUESTBODY = "{" + 
			"\"login_id\":\"qatechtest\"," + 
			"\"username\":\"qatechtest\"," +  
			"\"password\":\"12345678\"," + 
			"\"user_type\":\"dashboard\"" +
			"}";
	
	public static final String CONFIRMURL = "https://command-staging.assignar.com.au/v1/allocations/confirm";
	public static final String ALLOCATIONID = "{\"items\":[{\"id\":334}]}";
}
