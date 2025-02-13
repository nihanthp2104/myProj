package com.myProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myProject.domain.Domain;
import com.myProject.entity.MarksEntity;

@Repository
public interface MarksRepo extends JpaRepository<MarksEntity, Integer>{
	// JPArepository  -  using this we can give data <Class , primary variable type>
	//springboot jpa with mysql example
//public List<MarksEntity> findByStatus(String status);
//	@Query("select m from MarksEntity m where m.status = :status")
	@Query(value = "select me1_0.school_id,me1_0.s_id,me1_0.score,me1_0.status "
			+ "from marks me1_0 where me1_0.status=:status", nativeQuery = true)

	public List<MarksEntity> find(String status);
	
	@Query(value = "select s.s_id as studentId, s.s_name as studentName,m.s_id as schoolId,"
			+ "m.s_id as schoolRno, m.score as score, m.status as status from student s inner "
			+ "join marks m  on s.s_id=m.s_id;", nativeQuery = true)
	public List<Domain> fullData();
}
