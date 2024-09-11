package com.hexaware.Hibernate_Demo2;

import javax.persistence.Embeddable;

@Embeddable
public class Result {

	private int marks;
	private String sub;

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}
}
