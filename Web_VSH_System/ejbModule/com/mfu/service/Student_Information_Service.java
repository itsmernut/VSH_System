package com.mfu.service;

import java.util.List;

import com.mfu.entity.Student_Information;

public interface Student_Information_Service {

	public void saveStudent(Student_Information student);

	public void updateStudent(Student_Information student);

	public void deleteStudent(long studentNumber);
	
	public abstract Student_Information findStudent(long studentNumber);

	public List<Student_Information> getAllStudent();
	
	public List<Student_Information> getStudentByID(long id);
	
}
