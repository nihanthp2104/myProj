package com.myProject;

import java.util.Objects;

public class Emp {
	private String name;
	private int rno;
	private long salary;
	
	public Emp(String name,int rno,long salary) {
		this.name = name;
		this.rno = rno;
		this.salary = salary;		
	}

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, rno, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return Objects.equals(name, other.name) && rno == other.rno && salary == other.salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", rno=" + rno + ", salary=" + salary + "]";
	}
}
