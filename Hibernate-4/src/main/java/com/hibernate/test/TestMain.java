package com.hibernate.test;

import org.hibernate.Session;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.Person;

public class TestMain {
	public static void main(String[] args) {
		Person person1 = new Person();
		//person1.setId(1);
		person1.setName("Concretepage");
		Session session = HibernateUtil.getSessionFactory().openSession();
		//persist(session,person);
		save(session, person1);

		Person person2 = new Person();
		person2.setName("Concretepage");
		save(session, person2);
		session.close();
		HibernateUtil.getSessionFactory().close();
		
		System.out.println("Done");
	}

	private static void save(Session session, Person person) {
		//session.beginTransaction();
		session.save(person);
		//session.flush();
		//session.getTransaction().commit();
	}

	private static void persist(Session session, Person person) {
		session.beginTransaction();
		session.persist(person);
		/** persist the object. move it to first level cache(session cache) **/
		// session.flush(); /** send it to db cache**/
		session.getTransaction().commit();
		/** flush session and commit in db **/
	}
}
