package com.hexaware.Hibernate_Demo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@Column(name = "VEHICLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserDetails user;

	public int getVehicleId() {
		return vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
}
