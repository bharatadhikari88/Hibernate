package com.hibernate.inheritance;

import org.hibernate.Session;

import com.concretepage.HibernateUtil;

public class InheritanceTest {

	public static void main(String[] args) {
		
		save();
		
		//fetch();
		
		//delete();
		
		HibernateUtil.getSessionFactory().close();
	}

	private static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Base child1 = (Base)session.load(Base.class, new Integer(2));
		session.delete(child1);
		session.flush();
		Base child2 = new Base();
		child2.setId(3);
		session.delete(child2);
		session.flush();
		session.close();
	}

	private static void fetch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.get(Base.class, new Integer(1));
		session.get(Base.class, new Integer(2));
		session.get(Base.class, new Integer(3));
		session.close();
	}

	private static void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Base base = new Base();
		base.setBaseField("Base Field");
		base.setField2("Field2");
		
		Child1 child1 = new Child1();
		child1.setBaseField("child Base Field");
		child1.setChild1Field("Child 1 field");
		
		Child2 child2 = new Child2();
		child2.setBaseField("child Base Field");
		child2.setChild2Field("Child 2 field");
		
		session.save(base);
		session.save(child1);
		session.save(child2);
		session.flush();
		session.close();
	}

}
