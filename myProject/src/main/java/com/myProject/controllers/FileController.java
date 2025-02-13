package com.myProject.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myProject.entity.FileEntity;
import com.myProject.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {
//@Autowired
//FileService fileService;
//	@PostMapping("/upload")
//	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//	    try {
//	        FileEntity savedFile = fileService.saveFile(file);
//	        return ResponseEntity.ok("File uploaded successfully with ID: " + savedFile.getId());
//	    } catch (IOException e) {
//	        return ResponseEntity.internalServerError().body("File upload failed."+e.getMessage());
//	    }
//	}
}
