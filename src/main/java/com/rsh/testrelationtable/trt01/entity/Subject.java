package com.rsh.testrelationtable.trt01.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "student_enrolled",
			joinColumns = @JoinColumn(name = "subject_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> enrolledStudents = new HashSet<Student>();
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	private Teacher teacher;
	
	

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Student> getEnrollStudents() {
		return enrolledStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void enrollStudent(Student student) {
		enrolledStudents.add(student);
		
	}

	public void enrollTeacher(Teacher teacher) {
		this.teacher = teacher;
		
	}
	
	
	
}
