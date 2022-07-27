package com.rsh.testrelationtable.trt01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsh.testrelationtable.trt01.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
