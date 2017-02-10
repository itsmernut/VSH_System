package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mfu.entity.Student_Information;
import com.mfu.entity.Teacher_Information;

@Stateless
@Remote(Teacher_Information_Service.class)
public class Teacher_Information_ServiceBean implements Teacher_Information_Service {

	@PersistenceContext(unitName = "teacherDatabase")
	EntityManager teacher_information;
	
	@Override
	public void saveTeacher(Teacher_Information teacher) {
		this.teacher_information.persist(teacher);
	}

	@Override
	public void updateTeacher(Teacher_Information teacher) {
		teacher_information.merge(teacher);
	}

	@Override
	public void deleteTeacher(long teacherNumber) {
		Teacher_Information teacher = findTeacher(teacherNumber);
		if(teacher != null){
			teacher_information.remove(teacher);
		}
	}

	@Override
	public Teacher_Information findTeacher(long teacherNumber) {
		return this.teacher_information.find(Teacher_Information.class, teacherNumber);
	}

	@Override
	public List<Teacher_Information> getAllTeacher() {
		List<Teacher_Information> teacherlist = null;
		try{
			Query teacher = teacher_information.createQuery("select teacher from Teacher_Information teacher");
			teacherlist = teacher.getResultList();
		}	
		catch(Exception e){
			e.printStackTrace();
		}
		return teacherlist;
	}

	@Override
	public List<Teacher_Information> getTeacherByID(long id) {
		List<Teacher_Information> result = teacher_information.createQuery("select teacher from Teacher_Information teacher where teacher.teacherNumber=:param1")
				.setParameter("param1", id)
				.getResultList();
		return result;
	}

}
