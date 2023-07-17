package com.example.firstProject.demo.firstApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstProject.demo.firstApp.exception.CustomerExistException;
import com.example.firstProject.demo.firstApp.model.Student;
import com.example.firstProject.demo.firstApp.service.StudentService;

@RestController
@RequestMapping("save")
public class StudentController {
	
	@Autowired
	public StudentService studentservice;
	
	//post the data
	@PostMapping("/saveData")
	public ResponseEntity<?> saveStudent(@RequestBody Student student){
		try {
			Student st1=studentservice.saveMethod(student);
			return new ResponseEntity<Student>(st1,HttpStatus.CREATED);
		}catch(CustomerExistException e) {
			CustomerExistException ce=new CustomerExistException(e.getErrmsg(), e.getErrcode());
			return new ResponseEntity<CustomerExistException>(ce,HttpStatus.BAD_REQUEST);

		}

	}
	
	//fetch all data 
	@GetMapping("/get")
	public ResponseEntity<List<Student>> getAllStudent(){
		return ResponseEntity.ok(studentservice.getAllStudent());
	}
	
	//fetch data using id
	
	@GetMapping("/gets")
	public ResponseEntity<Student> getDataById(@RequestParam("id") long id){
		Student st2=studentservice.getDataById(id);
		return new ResponseEntity<Student>(st2,HttpStatus.OK);
		
	}
	
	
//	@GetMapping("/gets")
//	public Student getDataById(@RequestParam("id") long id){
//		
//		return 	studentservice.getDataById(id);
//	}
	
	//Delete data using id
	@DeleteMapping("/delete")
	public void deleteDataById(@RequestParam("id") long id){
		
		studentservice.deleteDataById(id);	
	}
	
	//update data using id
	@PutMapping("/update1")
	public ResponseEntity<Student> updateStudent(@RequestParam("id") long id,Student student){
		Student updt=studentservice.updateStudent(student);
		return new ResponseEntity<Student>(updt,HttpStatus.CREATED);
	}
	
	//update data using id
 	    @PutMapping("/update")
        public ResponseEntity<Student> updateStudent(@RequestBody Student student){
 		Student updt=studentservice.updateStudent(student);
		return new ResponseEntity<Student>(updt,HttpStatus.CREATED);
	}
	
	
}
 
	

