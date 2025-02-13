package com.myProject.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.controllers.MarksController;
import com.myProject.domain.Domain;
import com.myProject.entity.MarksEntity;
import com.myProject.entity.StudentEntity;
import com.myProject.repo.MarksRepo;
import com.myProject.repo.StudentRepo;
import com.myProject.service.MarksService;

import jakarta.transaction.Transactional;
@Service
public class MarksServiveImpl implements MarksService{
	private static final Logger logger = LogManager.getLogger(MarksServiveImpl.class);

	@Autowired
	MarksRepo marksRepo;
	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public List<MarksEntity> data() throws SQLException {
		
		List<MarksEntity> dta = marksRepo.findAll();
		//throw new SQLException();
		//return null;
		return dta;
	}
	@Override
	public List<MarksEntity> saveData(MarksEntity marksData) {
		marksRepo.save(marksData);
		return marksRepo.findAll();
	}
	@Override
	public List<MarksEntity> update(MarksEntity marksData2, Integer id) {
		MarksEntity updatedData=marksRepo.findById(id).get();
		updatedData.setrno(marksData2.getrno());
		updatedData.setScore(marksData2.getScore());
		updatedData.setStatus(marksData2.getStatus());
		marksRepo.save(updatedData);
		return marksRepo.findAll();
	}
	@Override
	public List<MarksEntity> findStatus(String status) {
		return marksRepo.find(status);
	}
	@Transactional	
	@Override
	public List<Domain> full(Domain domain) {
		MarksEntity marksEntity= new MarksEntity();
		StudentEntity studentEntity = new StudentEntity();
		
		marksEntity.setId(domain.getSchoolId());
		marksEntity.setrno(domain.getSchoolRno());
		marksEntity.setScore(domain.getScore());
		marksEntity.setStatus(domain.getStatus());
		
		studentEntity.setId(domain.getStudentId());
		studentEntity.setName(domain.getStudentName());
		
		studentRepo.save(studentEntity);
		marksRepo.save(marksEntity);
		
		List<StudentEntity> data1 = studentRepo.findAll();
		List<MarksEntity> data2=marksRepo.findAll();
		
		List<Domain> dataDomain1=data1.stream().map(s->{
			Domain domainObject =new Domain();
			domainObject.setStudentId(s.getId());
			domainObject.setStudentName(s.getName());

			return domainObject;
		 	}).toList();
		List<Domain> dataDomain2 = new ArrayList<>();
		data2.stream().map(x->{
			for(Domain i : dataDomain1) {
				System.out.println(i.getStudentId()+"->"+x.getrno());
				
				if (i.getStudentId().equals(x.getrno())) {
					i.setSchoolId(x.getId());
					i.setSchoolRno(x.getrno());
					i.setScore(x.getScore());
					i.setStatus(x.getStatus());
					dataDomain2.add(i);
					System.out.println(i);
				}	
			}
			return x;
		}).toList();

		return dataDomain2;	 
	}
	
	@Override
	public List<Domain> fullData() {
		logger.info("fullData service called");

		// TODO Auto-generated method stub
		return marksRepo.fullData();
	}
	
		


	





}
