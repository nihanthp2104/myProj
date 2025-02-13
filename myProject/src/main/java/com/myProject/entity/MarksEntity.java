package com.myProject.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "marks", schema = "customer")
public class MarksEntity implements Serializable{
	
	@Override
	public String toString() {
		return "MarksEntity [id=" + id + ", idrno=" + rno + ", score=" + score + ", status=" + status + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getrno() {
		return rno;
	}
	public void setrno(Integer rno) {
		this.rno = rno;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Id
	@Column(name = "school_id")
	private Integer id;
	@Column(name = "s_id",insertable = false,updatable = false)
	private Integer rno;
	@Column(name = "score")
	private Integer score;
	@Column(name = "status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "s_id")
	private StudentEntity studentEntity;
	


}
