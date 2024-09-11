package com.hexaware.crud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
 
	
	@Id
	int userId;
	String Name;
	Double Fee;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getFee() {
		return Fee;
	}
	public void setFee(Double fee) {
		Fee = fee;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", Name=" + Name + ", Fee=" + Fee + "]";
	}
	
	
	
	
}