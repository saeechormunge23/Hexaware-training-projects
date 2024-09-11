package com.hexaware.Hibernate_Demo2;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		UserDetails user = new UserDetails(); // create an user entity

		Vehicle vehicle = new Vehicle(); // create a vehicle entity
		Vehicle vehicle2 = new Vehicle(); // create second vehicle entity

		vehicle.setVehicleName("BMW Car"); // set BMW car
		vehicle.setUser(user); // set user for that car

		vehicle2.setVehicleName("AUDI Car"); // set second car Audi
		vehicle2.setUser(user);// set user for that car

		user.setUserName("Dinesh Rajput"); // set user property

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); // create the session
																								// factory object
		Session session = sessionFactory.openSession(); // create the session object
		session.beginTransaction(); // create the transaction object
		session.save(vehicle);
		session.save(vehicle2);
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

//	public static void main(String[] args) {
//		UserDetails user = new UserDetails(); // create the user entity object
//
//		Vehicle vehicle = new Vehicle(); // create the first vehicle entity object
//		Vehicle vehicle2 = new Vehicle(); // create the second vehicle entity
//
//		vehicle.setVehicleName("BMW Car"); // set the value to the vehicle entity
//		vehicle2.setVehicleName("AUDI Car");
//
//		user.setUserName("Dinesh Rajput"); // Set the value to the user entity
//		user.getVehicle().add(vehicle); // add vehicle to the list of the vehicle
//		user.getVehicle().add(vehicle2);
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); // create session factory
//																								// object
//		Session session = sessionFactory.openSession(); // create the session object
//		session.beginTransaction(); // start the transaction of the session object
//
//		session.save(vehicle); // saving the vehicle to the database
//		session.save(vehicle2);
//		session.save(user); // save the user to the database
//
//		session.getTransaction().commit(); // close the transaction
//		session.close(); // close the session
//
//	}

//	public static void main(String[] args) {
//		UserDetails user = new UserDetails(); // create the user entity
//		Vehicle vehicle = new Vehicle(); // create the vehicle entity
//
//		vehicle.setVehicleName("BMW Car"); // set vehicle name
//
//		user.setUserName("Dinesh Rajput"); // set the user name
//		user.setVehicle(vehicle); // set the vehicle entity to the field of the user entity i.e. vehicle entity
//									// inside the user entity
//
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); // create session factory
//																								// object
//		Session session = sessionFactory.openSession(); // create the session object
//		session.beginTransaction();// create the transaction from the session object
//
//		session.save(vehicle); // save the vehicle entity to the database
//		session.save(user); // save the user entity to the database
//
//		session.getTransaction().commit(); // close the transaction
//		session.close(); // close the session
//
//	}

//	SessionFactory fac;
//	Session ses;
//	Transaction tx;
//
//	App() {
//		fac = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Student.class)
//				.addAnnotatedClass(Certificate.class).buildSessionFactory();
//		ses = fac.openSession();
//	}
//
//	void insertStud() {
//		tx = ses.beginTransaction();
//
//		Certificate cert = new Certificate();
//		cert.setDateOfExp("4th October, 2024");
//
//		Student student = new Student();
//		student.setName("Lalit");
//		student.setCert(cert);
//		ses.save(student);
//		tx.commit();
//		System.out.println("Updated!");
//	}
//
////	void insertStud() {
////		tx = ses.beginTransaction();
////
////		Result result = new Result();
////		result.setMarks(101);
////		result.setSub("dsa");
////
////		Student student = new Student();
////		student.setRoll(101);
////		student.setName("asha");
////		student.setFee(5000.0);
////		student.setRes(result);
////		ses.save(student);
////		tx.commit();
////		System.out.println("Updated!");
////	}
//
//	void insertEmp() {
//		tx = ses.beginTransaction();
//		Employee emp = new Employee();
//		emp.setName("Om");
//		emp.setRegNo(21);
//		emp.setFee(34999.99);
//		emp.setSubject("Mentorship");
//		ses.save(emp);
//		tx.commit();
//		System.out.println("Updated!");
//	}
//
//	void insertBook() {
//		tx = ses.beginTransaction();
//		Book b = new Book();
//		b.setBno(4);
//		b.setName("IT");
//		b.setPrice(299.9);
//		ses.save(b);
//		tx.commit();
//		System.out.println("Updated!");
//	}
//
//	void removeByBNo(int bNo) {
//		tx = ses.beginTransaction();
//		Book b = ses.find(Book.class, bNo);
//		if (b != null) {
//			ses.delete(b);
//			tx.commit();
//			System.out.println("Deleted!");
//		} else {
//			System.out.println("Book Not Found...");
//		}
//	}
//
//	void updatePriceByBNo(int bNo, double price) {
//		tx = ses.beginTransaction();
//		Book b = ses.find(Book.class, bNo);
//		if (b != null) {
//			b.setPrice(price);
//			ses.update(b);
//			tx.commit();
//			System.out.println("Price Updated!");
//		} else {
//			System.out.println("Book Not Found...");
//		}
//	}
//
//	void searchByBNo(int bNo) {
//		tx = ses.beginTransaction();
//		Book b = ses.find(Book.class, bNo);
//		if (b != null) {
//			System.out.println("Book Name: " + b.getName());
//		} else {
//			System.out.println("Book Not Found...");
//		}
//	}
//
//	void showAll() {
//		tx = ses.beginTransaction();
//		Query q = ses.createQuery("from Book ");
//		List<Book> books = q.list();
//		for (Book b : books) {
//			System.out.println(b.toString());
//		}
//	}
//
//	public static void main(String[] args) {
//		App app = new App();
//		app.insertStud();
//
////		App app = new App();
////		Scanner sc = new Scanner(System.in);
////		app.insertBook();
////		app.removeByBNo(1);
////		System.out.println("Enter the Book No to update Price: ");
////		int bNo = sc.nextInt();
////		sc.nextLine();
////		System.out.println("Enter the new Price: ");
////		double newPrice = sc.nextDouble();
////		app.updatePriceByBNo(bNo, newPrice);
////		System.out.println("Enter the Book No to find Name: ");
////		int bkNo = sc.nextInt();
////		sc.nextLine();
////		app.searchByBNo(bkNo);
////		app.showAll();
//
////		SessionFactory fac = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Book.class)
////				.buildSessionFactory();
////
////		Session ses = fac.openSession();
////
////		Transaction tx = ses.beginTransaction();
////
////		Book b1 = new Book();
////		b1.setBno(1);
////		b1.setName("ECE");
////		b1.setPrice(80.80);
////
////		ses.save(b1);
////		tx.commit();
////		System.out.println("Updated!");
//	}
}
