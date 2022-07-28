package com.rsh.testrelationtable.trt01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsh.testrelationtable.trt01.entity.Student;
import com.rsh.testrelationtable.trt01.entity.Subject;
import com.rsh.testrelationtable.trt01.repository.StudentRepository;
import com.rsh.testrelationtable.trt01.repository.SubjectRepository;



@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@GetMapping
	List<Subject> getSubjects(){
		return subjectRepository.findAll();
	}
	
	@PostMapping
	Subject createSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@PutMapping("/{subjectId}/students/{studentId}")
	Subject enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
		
		Optional<Subject> subjectOptional = subjectRepository.findById(subjectId);
		
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		
		
		Subject subject = subjectOptional.get();
		Student student = studentOptional.get();
		
		subject.enrollStudent(student);
		
		return subjectRepository.save(subject);
	}
	
}
