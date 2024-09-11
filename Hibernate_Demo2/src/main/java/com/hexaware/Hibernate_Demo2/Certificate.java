package com.hexaware.Hibernate_Demo2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Certificate {

	@Id
	@GeneratedValue
	private Long certNo;
	
	private String dateOfExp;

	public Long getCertNo() {
		return certNo;
	}

	public void setCertNo(Long certNo) {
		this.certNo = certNo;
	}

	public String getDateOfExp() {
		return dateOfExp;
	}

	public void setDateOfExp(String dateOfExp) {
		this.dateOfExp = dateOfExp;
	}
}
