package com.myProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myProject.entity.StudentEntity;
@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer>{
	
	//public StudentEntity findByIdAndName(Integer id, String name);	//JPA Feature
	
//	@Query("select s from StudentEntity s where id = :id AND name = :name")	//hibernate or jpa query
	//coz used class name as a table name. 
	
	@Query(value = "select se1_0.s_id,se1_0.s_name from student se1_0 where se1_0.s_id="
			+ " :id and se1_0.s_name= :name", nativeQuery = true)	
	//writing in sql
	
	
	public StudentEntity find(Integer id, String name);
	// JPArepository  -  using this we can give data <Class , primary variable type>
	//springboot jpa with mysql example

}

