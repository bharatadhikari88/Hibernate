package com.hibernate.test;

import org.hibernate.Session;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.Address;
import com.hibernate.entities.Person;
import com.hibernate.entities.Student;

public class OneToOneTest2 {

	public static void main(String[] args) {
		save();
		
		getAddress();
		
		getStudent();
		HibernateUtil.getSessionFactory().close();
		
	}

	private static void getStudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = (Student)session.get(Student.class, 1);
		//session.close();
		System.out.println(student.getStudentAddress());// default get for one to one is eager
	}

	private static void getAddress() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Address address = (Address)session.get(Address.class, 1);
		session.close();
		System.out.println(address.getStudent().getName());
	}

	private static void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = new Student();
		Address address = new Address();
		address.setCity("Chandigarh");
		student.setStudentAddress(address);
		student.setName("Bharat");
		Person person = new Person();
		person.setAddress(address);
		session.beginTransaction();
		session.persist(person);
		session.persist(student);
		session.getTransaction().commit();
		session.close();
	}

}
