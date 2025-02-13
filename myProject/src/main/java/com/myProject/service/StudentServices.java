package com.myProject.service;

import java.util.List;

import com.myProject.domain.Domain;
import com.myProject.domain.StudentDomain;
import com.myProject.entity.StudentEntity;

public interface StudentServices {
	
public List<StudentEntity> getAllStudents();
public StudentEntity find(Integer id, String name); 
public Integer sumormul(Integer a,Integer b,String c);
public List<StudentDomain> addNewStudent(StudentDomain studentDomain);

}
