package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.engine.internal.SessionEventListenerManagerImpl;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.Stock;

public class EventListenerTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.addEventListeners(new SessionEventListenerManagerImpl() {
			@Override
			public void flushStart() {
				System.out.println("Session Flush start");
			}

			@Override
			public void flushEnd(int numberOfEntities, int numberOfCollections) {
				System.out.println("Session Flush end");

			}
		});
		Stock stock = new Stock();
		stock.setName("Stock1");
		session.save(stock);
		session.flush();
		session.close();
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.get(Stock.class, 1);
		session.close();
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.get(Stock.class, 1);
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
