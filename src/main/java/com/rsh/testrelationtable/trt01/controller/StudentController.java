package com.rsh.testrelationtable.trt01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsh.testrelationtable.trt01.entity.Student;
import com.rsh.testrelationtable.trt01.repository.StudentRepository;



@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping
	List<Student> getStudents() {return studentRepository.findAll();}
	
	@PostMapping
	Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
}
