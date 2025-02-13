package com.myProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.domain.Domain;
import com.myProject.domain.StudentDomain;
import com.myProject.entity.StudentEntity;
import com.myProject.service.StudentServices;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired // To create an object
	StudentServices studentservices;

	@GetMapping("/all")
	public ResponseEntity<List<StudentEntity>> getall() {
		return ResponseEntity.ok(studentservices.getAllStudents());
		 //return ResponseEntity.badRequest().body(null);
	}
	
	@GetMapping("/find/{id}/{name}")
	public StudentEntity findstudent(@PathVariable Integer id, @PathVariable String name) {

		return studentservices.find(id, name);
	}
	
	@GetMapping("/gets")
	public Integer sumormul(@RequestParam Integer a, @RequestParam Integer b,
			@RequestParam String c) {
		Integer res= studentservices.sumormul(a, b, c);
		System.out.println(res);
		return res;
	}

	@PostMapping("/save")
	public List<StudentDomain> addemp(@RequestBody StudentDomain studentDomain){
//		studentrepo.save(studentData);
//		List<StudentEntity> list = studentrepo.findAll();
		return studentservices.addNewStudent(studentDomain);
	}

}
