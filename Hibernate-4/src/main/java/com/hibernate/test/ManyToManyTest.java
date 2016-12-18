package com.hibernate.test;

import org.hibernate.Session;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.User;
import com.hibernate.entities.Vehicle;

public class ManyToManyTest {

	public static void main(String[] args) {

		save();
		
		//fetch();
		
		//delete();
		
		HibernateUtil.getSessionFactory().close();
	}

	private static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		/*User user = new User();
		user.setId(1);
		session.delete(session.load(User.class,1));*/
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1);
		session.delete(vehicle);
		session.flush();
		session.close();
	}

	private static void fetch() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//User user = (User)session.get(User.class, 1);
		Vehicle vehicle = (Vehicle)session.get(Vehicle.class, 3);
		session.close();
		//System.out.println(user.getVehicles().size());
		System.out.println(vehicle.getUsers().size());
	}

	private static void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		User user = new User();
		user.setUserName("bharat");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setType("Car");
		vehicle.getUsers().add(user);
		
		user.getVehicles().add(vehicle);
		
		vehicle = new Vehicle();
		vehicle.setType("bike");
		vehicle.getUsers().add(user);
		
		user.getVehicles().add(vehicle);
		session.persist(user);
		
		
		vehicle = new Vehicle();
		vehicle.setType("Auto");
		
		user = new User();
		user.setUserName("Singh");
		user.getVehicles().add(vehicle);
		
		vehicle.getUsers().add(user);
		
		user = new User();
		user.setUserName("Adikari");
		user.getVehicles().add(vehicle);
		vehicle.getUsers().add(user);
		
		session.persist(vehicle);
		
		session.flush();
		session.close();
	}

}
