package com.example.firstProject.demo.firstApp.service;

import java.util.List;

import com.example.firstProject.demo.firstApp.model.Student;

public interface StudentService {

	Student saveMethod(Student student);

	List<Student> getAllStudent();

	Student getDataById(long id);

	void deleteDataById(long id);

	Student updateStudent(Student student);

	

	
   

	

	
	
	
	

}
