package com.myProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.entity.FileEntity;

@Repository
public interface FileRepo extends JpaRepository<FileEntity, Long> {

}
