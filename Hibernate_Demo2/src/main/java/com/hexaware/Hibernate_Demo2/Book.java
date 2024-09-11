package com.hexaware.Hibernate_Demo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	int Bno;
	@Column(name = "bkname")
	String Name;
	@Column
	Double price;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bno, String name, Double price) {
		super();
		Bno = bno;
		Name = name;
		this.price = price;
	}

	public int getBno() {
		return Bno;
	}

	public void setBno(int bno) {
		Bno = bno;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [Bno=" + Bno + ", Name=" + Name + ", price=" + price + "]";
	}

}
