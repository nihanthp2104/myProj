package com.myProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data						
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address", schema = "customer")
public class AddressEntity {
	
	@Id
	private Integer id;
	@Column(name = "s_id",insertable = false,updatable = false)
	private Integer sId;
	private String addrType;
	private String address;
	
//	@ManyToOne
//	@JoinColumn(name = "s_id")
//	private StudentEntity studentEntity;
	
	
}
