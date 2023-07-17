package com.example.firstProject.demo.firstApp.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.firstProject.demo.firstApp.exception.CustomerExistException;
import com.example.firstProject.demo.firstApp.model.Student;
import com.example.firstProject.demo.firstApp.repository.StudentRepository;
import com.example.firstProject.demo.firstApp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentRepository studentRepository;

	@Override
	public Student saveMethod(Student student) {
		try {
			if(student.getName().isEmpty() || student.getName().length() == 0)
			{
				throw new CustomerExistException("7001","name can not be empty and size 0");
			}
			Student st=studentRepository.save(student);
			return st;
		} catch(Exception e) {
			
			throw new CustomerExistException("7003","something is wrong in you and controller");
		}
		
	}
	
	@Override
	public List<Student> getAllStudent() {
			
		return studentRepository.findAll();
	}


	@Override
	public Student getDataById(long id) {
		
		return studentRepository.findById(id).get();
	}

	
	@Override
	public void deleteDataById(long id) {
		
		studentRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}

	
	



	

	
}


