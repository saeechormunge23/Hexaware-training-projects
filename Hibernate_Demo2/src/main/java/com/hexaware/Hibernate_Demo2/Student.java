package com.hexaware.Hibernate_Demo2;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long regNo;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Certificate cert;

	public Long getRegNo() {
		return regNo;
	}

	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Certificate getCert() {
		return cert;
	}

	public void setCert(Certificate cert) {
		this.cert = cert;
	}
//	@Id
//	@GeneratedValue
//	private int roll;
//	
//	@Column
//	private String name;
//	private double fee;
//
//	@Embedded
//	private Result res;
//
//	public int getRoll() {
//		return roll;
//	}
//
//	public void setRoll(int roll) {
//		this.roll = roll;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public double getFee() {
//		return fee;
//	}
//
//	public void setFee(double fee) {
//		this.fee = fee;
//	}
//
//	public Result getRes() {
//		return res;
//	}
//
//	public void setRes(Result res) {
//		this.res = res;
//	}
}
