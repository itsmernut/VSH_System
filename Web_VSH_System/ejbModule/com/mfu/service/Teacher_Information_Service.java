package com.mfu.service;

import java.util.List;

import com.mfu.entity.Teacher_Information;

public interface Teacher_Information_Service {

	public void saveTeacher(Teacher_Information teacher);

	public void updateTeacher(Teacher_Information teacher);

	public void deleteTeacher(long teacherNumber);
	
	public abstract Teacher_Information findTeacher(long teacherNumber);

	public List<Teacher_Information> getAllTeacher();
	
	public List<Teacher_Information> getTeacherByID(long id);
	
}
