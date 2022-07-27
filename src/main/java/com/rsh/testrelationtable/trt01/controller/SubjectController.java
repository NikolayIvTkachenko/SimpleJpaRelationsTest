package com.rsh.testrelationtable.trt01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsh.testrelationtable.trt01.entity.Subject;
import com.rsh.testrelationtable.trt01.repository.SubjectRepository;



@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	SubjectRepository subjectRepository;
	
	@GetMapping
	List<Subject> getSubjects(){
		return subjectRepository.findAll();
	}
	
	@PostMapping
	Subject createSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
}
