package com.mfu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher_Information {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long teacherNumber;
	
	private String teacherId;
	private String firstName;
	private String lastName;
	private String classRoom;
	private String email;
	private String password;
	
	
	public long getTeacherNumber() {
		return teacherNumber;
	}
	public void setTeacherNumber(long teacherNumber) {
		this.teacherNumber = teacherNumber;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
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
