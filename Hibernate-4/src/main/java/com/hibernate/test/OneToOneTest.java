package com.hibernate.test;

import org.hibernate.Session;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.Address;
import com.hibernate.entities.Person;

public class OneToOneTest {

	public static void main(String[] args) {
		save();
		
		delete();
		get();
		HibernateUtil.getSessionFactory().close();
	}

	private static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Person person = (Person)session.load(Person.class, 1);
		//session.close();
		//session = HibernateUtil.getSessionFactory().openSession();
		Person person = new Person();
		person.setId(1);
		Address address = new Address();
		address.setId(1);
		//address.setPerson(person);
		//person.setAddress(address);
		//Address address = (Address)session.load(Address.class, 1);
		//session.close();
		//session = HibernateUtil.getSessionFactory().openSession();
		session.delete(address);
		session.flush();
		session.close();
	}

	private static void get() {
		// TODO Auto-generated method stub
		
	}

	private static void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Person person = new Person();
		person.setName("Bharat");
		
		Address address = new Address();
		address.setCity("Chandigarh");

		person.setAddress(address);
		
		session.beginTransaction();
		session.persist(person);
		session.getTransaction().commit();
		session.close();
	}

}
