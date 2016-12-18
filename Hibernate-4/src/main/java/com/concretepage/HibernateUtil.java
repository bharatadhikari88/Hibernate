package com.concretepage;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreLoadEvent;
import org.hibernate.event.spi.PreLoadEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;

import com.hibernate.interceptors.SessionFactoryTestInterceptor;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().setInterceptor(
				new SessionFactoryTestInterceptor()).configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		bindEventListenerRegistry();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private static void bindEventListenerRegistry() {
		EventListenerRegistry eventListenerRegistry = ((SessionFactoryImpl) sessionFactory)
				.getServiceRegistry().getService(EventListenerRegistry.class);
		eventListenerRegistry.appendListeners(EventType.PRE_INSERT,
				new CustomListener());
		eventListenerRegistry.appendListeners(EventType.POST_INSERT,
				new CustomListener());

		eventListenerRegistry.appendListeners(EventType.PRE_LOAD,
				new CustomListener());
		eventListenerRegistry.appendListeners(EventType.POST_LOAD,
				new CustomListener());
	}

	private static class CustomListener implements PreInsertEventListener,
			PostInsertEventListener, PreLoadEventListener,
			PostLoadEventListener {

		@Override
		public boolean onPreInsert(PreInsertEvent event) {
			event.getState()[0]="Stock45";
			System.out.println("Session factory pre insert");
			return false;
		}

		@Override
		public void onPostInsert(PostInsertEvent event) {
			System.out.println("Session factory post insert");
		}

		@Override
		public boolean requiresPostCommitHanding(EntityPersister persister) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onPreLoad(PreLoadEvent event) {
			System.out.println("Session factory pre load event");
		}

		@Override
		public void onPostLoad(PostLoadEvent event) {
			System.out.println("Session factory post load event");
		}
	}
}
