package com.myProject.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.domain.Domain;
import com.myProject.domain.StudentDomain;
import com.myProject.entity.StudentEntity;
import com.myProject.repo.StudentRepo;
import com.myProject.service.StudentServices;
@Service
public class StudentServicesImpl implements StudentServices {
	@Autowired								//To create an object
	StudentRepo studentrepo;
	public List<StudentEntity> getAllStudents(){
		List<StudentEntity> list = studentrepo.findAll();	//select * from student
		return list;
	}
	
	public StudentEntity find(Integer id, String name) {
		StudentEntity data =studentrepo.find(id,name);
		return data;
		
	}

	@Override
	public Integer sumormul(Integer a, Integer b, String c) {
		if(c.equals("add")) {
			return a+b;
		}
		else if(c.equals("mul")) {
			return a*b;
		}

		return null;
	}

	@Override
	public List<StudentDomain> addNewStudent(StudentDomain studentDomain) {
		
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setId(studentDomain.getStudentId());
		studentEntity.setName(studentDomain.getStudentName());
		studentrepo.save(studentEntity);
		List<StudentEntity> dataList=studentrepo.findAll();
		return dataList.stream().map(x->{
			StudentDomain studentDomain2 = new StudentDomain();
			studentDomain2.setStudentId(x.getId());
			studentDomain2.setStudentName(x.getName());
			return studentDomain2;
		}).collect(Collectors.toList());

	}
	
}
