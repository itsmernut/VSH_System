package com.mfu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin_Information {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminNumber;
	
	private String adminId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	public long getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(long adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
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
	
}
