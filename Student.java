package com.example.firstProject.demo.firstApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@Data
@Entity
@Table(name="student_Data")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 45)
	
	private String name;
	private String email;
	private long age;
	private long contact;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private List<Teacher> teacher;
	
	
}
