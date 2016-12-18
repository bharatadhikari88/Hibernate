package com.hibernate.test;


import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.Stock;

public class CachingTest {

	public static void main(String[] args) {
		save();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		/** query cache store actual entity in secondary cache only**/
		Query query =  session.createQuery("from Stock");
		query.setCacheable(true);
		query.list();
		
		/*Query query = session.getNamedQuery("Stock.byId");
		query.list();*/
		
		/*Stock stock = (Stock)session.get(Stock.class, new Integer(1));
		System.out.println(stock.getName());
		stock.setName("Stock");
		session.flush();*/
		session.close();
		
		
		/** cleaing secondary cache **/
		//HibernateUtil.getSessionFactory().getCache().evictEntityRegion(Stock.class);
		
		/** for each id in query cache it fire query **/
		session = HibernateUtil.getSessionFactory().openSession();
		query =  session.createQuery("from Stock");
		query.setCacheable(true);
		query.list();
		
		
		/*stock = (Stock)session.get(Stock.class, new Integer(1));
		System.out.println(stock.getName());*/
		session.close();
		HibernateUtil.getSessionFactory().getCache().evictAllRegions();
		HibernateUtil.getSessionFactory().close();
		
				
	}

	private static void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Stock stock = new Stock();
		stock.setName("Stock");
		stock.getStockCategories().add("Cat1");
		stock.getStockCategories().add("Cat2");
		stock.getTestMap().put("Sample1", 1);
		stock.getTestMap().put("Sample2", 2);
		session.save(stock);
		stock = new Stock();
		stock.setName("Stock2");
		stock.getStockCategories().add("Cat1");
		stock.getStockCategories().add("Cat2");
		session.save(stock);
		session.flush();
		session.close();
	}

}
