package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mfu.entity.Student_Information;

@Stateless
@Remote(Student_Information_Service.class)
public class Student_Information_ServiceBean implements Student_Information_Service {

	@PersistenceContext(unitName = "studentDatabase")
	EntityManager student_information;
	
	@Override
	public void saveStudent(Student_Information student) {
		this.student_information.persist(student);
	}

	@Override
	public void updateStudent(Student_Information student) {
		student_information.merge(student);
	}

	@Override
	public void deleteStudent(long studentNumber) {
		Student_Information student = findStudent(studentNumber);
		if(student != null){
			student_information.remove(student);
		}
	}

	@Override
	public Student_Information findStudent(long studentNumber) {
		return this.student_information.find(Student_Information.class, studentNumber);
	}

	@Override
	public List<Student_Information> getAllStudent() {
		List<Student_Information> studentlist = null;
		try{
			Query student = student_information.createQuery("select student from Student_Information student");
			studentlist = student.getResultList();
		}	
		catch(Exception e){
			e.printStackTrace();
		}
		return studentlist;
	}

	@Override
	public List<Student_Information> getStudentByID(long id) {
		List<Student_Information> result = student_information.createQuery("select student from Student_Information student where student.studentNumber=:param1")
				.setParameter("param1", id)
				.getResultList();
		return result;
	}

}
