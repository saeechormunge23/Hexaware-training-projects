package com.hexaware.pnbbank.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PNBbank_user {
	@Id
	int accNo;
	String Name;
	double balance;
	
	
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "pnbbank [accNo=" + accNo + ", Name=" + Name + ", balance=" + balance + "]";
	}

}
