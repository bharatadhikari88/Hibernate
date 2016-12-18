package com.hibernate.test;

import org.hibernate.Session;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.Stock;
import com.hibernate.interceptors.SessionTestInterceptor;

public class InterceptorTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().withOptions()
				.interceptor(new SessionTestInterceptor()).openSession();
		Stock stock = (Stock)session.get(Stock.class, 1);
		System.out.println("Session " + stock.getName());
		session.close();
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.get(Stock.class, 1);
		System.out.println("Session factory " + stock.getName());
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
