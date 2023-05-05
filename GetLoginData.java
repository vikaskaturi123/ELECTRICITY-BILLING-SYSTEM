package com.electricitybillingsystem.entity;



public class GetLoginData {
	
	
	private String Username;
	
	private String Password;
	private String Char_ID;
	
	public String getChar_ID() {
		return Char_ID;
	}
	public void setChar_ID(String char_ID) {
		Char_ID = char_ID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "GetLoginData [Username=" + Username + ", Password=" + Password + ", Char_ID="+Char_ID+"]";
	}
	public GetLoginData() {
		super();
	
	}
	
	
	
}
