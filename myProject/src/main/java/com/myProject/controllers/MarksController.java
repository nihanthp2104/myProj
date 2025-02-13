package com.myProject.controllers;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.domain.Domain;
import com.myProject.entity.MarksEntity;
import com.myProject.service.MarksService;

@RestController
@RequestMapping("/api/marks")
public class MarksController {
	private static final Logger logger = LogManager.getLogger(MarksController.class);
	@Autowired
	MarksService marksservice;
	
	@GetMapping("/data")
	public List<Domain> fullData(){
		logger.info("fullData called");
		return marksservice.fullData();
		
	}
	
	@PostMapping("/full")
	public List<Domain> full(@RequestBody Domain domain){
		return marksservice.full(domain);	
	}
	

	
	@GetMapping("/write")
	public String write() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\myproj\\Sample2.txt"))) {
			List<MarksEntity> www = marksservice.data();
			bw.write(www.get(0).toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GetMapping("/input1")
	public String sqlin(){
		try(InputStreamReader isr = new InputStreamReader(
				new FileInputStream("F:\\myproj\\Sample2.txt"));) {
			int c;
			StringBuffer str = new StringBuffer();
			while((c = isr.read())!=-1) {
				System.out.print((char)c);
				str.append((char)c);
			}
			return str.toString();
		} catch (IOException e) {
			e.getMessage();
		} 
		return null;	
	}
	
	@GetMapping("/input2")
	public MarksEntity sqlinput(){
		try(ObjectInputStream ois= new ObjectInputStream(
				new FileInputStream("F:\\myproj\\Sample2.txt"))){
			return (MarksEntity) ois.readObject();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;	
	}
	
	@GetMapping("/output")
	public String sqlout(){
		try(ObjectOutputStream oos= new ObjectOutputStream(
				new FileOutputStream("F:\\myproj\\Sample2.txt"))){
			List<MarksEntity> www = marksservice.data();
			oos.writeObject(www.get(0));
		} catch (IOException | SQLException e) {
			e.getMessage();
		}
		return null;	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/all")
	public List<MarksEntity> take(){
		List<MarksEntity> result= null;

		try {
			result =  marksservice.data();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			result = null;
			System.out.println("Donefinally");
		}
		System.out.println("Done");	
		
		
		return null;
	}
	@PostMapping("/save")
	public List<MarksEntity> add(@RequestBody MarksEntity marksData){
		return marksservice.saveData(marksData);
	}
	@PutMapping("/update/{id}")
	public List<MarksEntity> gets(@RequestBody MarksEntity marksData2, @PathVariable Integer id) {
		return marksservice.update(marksData2, id);
	}
	@GetMapping("/find/{status}")
	public List<MarksEntity> find(@PathVariable String status) {
		return marksservice.findStatus(status);
	}

	
	
	
	
	
//	@PutMapping("update/{id}")
//	public List<MarksEntity> update(@RequestBody MarksEntity marksData,@PathVariable Integer id){
//		MarksEntity adds = marksrepo.findById(id).get();
//		adds.setrno(marksData.getrno());
//		adds.setScore(marksData.getScore());
//		adds.setStatus(marksData.getStatus());
//		marksrepo.save(adds);
//		List<MarksEntity> updatedData=marksrepo.findAll();
//			
//		return updatedData;
//
//	}
//	@DeleteMapping("/remove/{id}")
//	public List<MarksEntity> delete(@PathVariable Integer id){
//		
//		marksrepo.deleteById(id);
//		return marksrepo.findAll(); 
//	}
}
