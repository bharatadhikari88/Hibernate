package com.hibernate.test;

import org.hibernate.Session;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.Person;

public class UpdateTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Person p1 = (Person)session.get(Person.class, 1);
		Person p2 = new Person();
		p2.setId(1);
		p2.setName("Bharat Singh");
		//session.evict(p1);              //detach object. remove from session cache
		session.update(p2);             //persisted object already in session cache with same primary key
		//session.merge(p2);                //copy the p2 state in persisted object and return persisted object
		p2.setAge(27);					 // return object of merge is persisted, p2 is not persisted 
										// merge take care of insert in case of new id.
		try{
			session.flush();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		HibernateUtil.getSessionFactory().close();
	}
}
