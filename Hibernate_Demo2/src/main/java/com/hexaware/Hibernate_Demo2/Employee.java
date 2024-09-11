package com.hexaware.Hibernate_Demo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	long EmpId;
	@Column
	String name;
	int RegNo;
	Double fee;
	@Transient
	String Subject;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long empId, String name, int regNo, Double fee, String subject) {
		super();
		EmpId = empId;
		this.name = name;
		RegNo = regNo;
		this.fee = fee;
		Subject = subject;
	}

	public long getEmpId() {
		return EmpId;
	}

	public void setEmpId(long empId) {
		EmpId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegNo() {
		return RegNo;
	}

	public void setRegNo(int regNo) {
		RegNo = regNo;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", name=" + name + ", RegNo=" + RegNo + ", fee=" + fee + ", Subject="
				+ Subject + "]";
	}
}
