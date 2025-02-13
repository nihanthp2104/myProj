package com.myProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.entity.AddressEntity;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Integer>{

	
}
