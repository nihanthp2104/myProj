package com.myProject.entity;

import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity()
@Table(name = "student", schema = "customer")

public class StudentEntity {
	@Id
	@Column(name = "s_id")
	private Integer id;
	@Column(name = "s_name")
	private String name;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + "]";
	}
	
	@OneToOne(mappedBy = "studentEntity")
	private MarksEntity marksEntity;

	public MarksEntity getMarksEntity() {
		return marksEntity;
	}
	public void setMarksEntity(MarksEntity marksEntity) {
		this.marksEntity = marksEntity;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "s_id")
	
	private List<AddressEntity> addressList;

	public List<AddressEntity> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressEntity> addressList) {
		this.addressList = addressList;
	} 
	
}
