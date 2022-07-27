package com.rsh.testrelationtable.trt01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsh.testrelationtable.trt01.entity.Teacher;



@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>  {

}
