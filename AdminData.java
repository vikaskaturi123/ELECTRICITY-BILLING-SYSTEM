package com.electricitybillingsystem.entity;

import java.util.List;

public class AdminData {
	private String Admin_username;
	private String password;
	private String id;
	
	public String getAdmin_username() {
		return Admin_username;
	}
	public void setAdmin_username(String admin_username) {
		Admin_username = admin_username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
