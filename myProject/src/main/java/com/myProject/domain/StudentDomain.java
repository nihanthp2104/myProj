package com.myProject.domain;

public class StudentDomain {

	private Integer studentId;
	private String studentName;
	private String gender;
	
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "StudentDomain [studentId=" + studentId + ", studentName=" + studentName + ", gender=" + gender + "]";
	}
	
}
