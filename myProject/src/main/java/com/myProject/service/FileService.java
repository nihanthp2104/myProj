package com.myProject.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myProject.entity.FileEntity;

@Service
public interface FileService {

	public ResponseEntity<String> saveFile(MultipartFile file);
}
