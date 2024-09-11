package com.hexaware.Hibernate_Demo2;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserDetails {

	@Column(name = "USER_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

//@Entity
//@Table(name = "USER")
//public class UserDetails {
//
//	@Id
//	@Column(name = "USER_ID")
//	private int userId;
//
//	@Column(name = "USER_NAME")
//	private String userName;
//
//	@OneToMany
//	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public Collection<Vehicle> getVehicle() {
//		return vehicle;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public void setVehicle(Collection<Vehicle> vehicle) {
//		this.vehicle = vehicle;
//	}
//
//}

//@Entity
//@Table(name = "USER_DETAIL")
//public class UserDetails {
//
//	@Id
//	@Column(name = "USER_ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int userId;
//
//	@Column(name = "USER_NAME")
//	private String userName;
//
//	@OneToOne
//	@JoinColumn(name = "VEHICLE_ID")
//	private Vehicle vehicle;
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}
//}
