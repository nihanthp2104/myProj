package com.myProject.domain;

public class Domain {
	private Integer studentId;
	private String studentName;
	private Integer schoolId;
	private Integer schoolRno;
	private Integer score;
	private String status;

	
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

	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public Integer getSchoolRno() {
		return schoolRno;
	}
	public void setSchoolRno(Integer schoolRno) {
		this.schoolRno = schoolRno;
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
	public Domain() {
		
	}

	public Domain(Integer studentId, String studentName, Integer schoolId, Integer schoolRno, Integer score,
			String status) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.schoolId = schoolId;
		this.schoolRno = schoolRno;
		this.score = score;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Domain [studentId=" + studentId + ", studentName=" + studentName + ", schoolId="
				+ schoolId + ", schoolRno=" + schoolRno + ", score=" + score + ", status=" + status + "]";
	}
	

}
