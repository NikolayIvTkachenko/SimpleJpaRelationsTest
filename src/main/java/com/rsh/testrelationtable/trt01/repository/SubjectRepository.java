package com.rsh.testrelationtable.trt01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsh.testrelationtable.trt01.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
