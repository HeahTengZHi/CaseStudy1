package com.java.pojo;

public class User {
	private String userID;	//email ID
	private String password; //password
	private double amount; //saving amount
	private String securityKey; //for forget password
	
	//Enable you to create user account in one line
	public User(String userID,String password,double amount,String securityKey){
		this.userID=userID;
		this.password=password;
		this.amount=amount;
		this.securityKey=securityKey;
	}
	
	//generate setter and getter
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getSecurityKey() {
		return securityKey;
	}
	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}
	
	
}
