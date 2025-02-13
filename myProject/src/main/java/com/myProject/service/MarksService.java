package com.myProject.service;

import java.sql.SQLException;
import java.util.List;

import com.myProject.domain.Domain;
import com.myProject.entity.MarksEntity;

public interface MarksService {
	
public List<MarksEntity> data()throws SQLException;
public List<MarksEntity> saveData(MarksEntity marksData);
public List<MarksEntity> update(MarksEntity marksData2, Integer id);
public List<MarksEntity> findStatus(String status);
public List<Domain> full(Domain domain);
public List<Domain> fullData();
}
