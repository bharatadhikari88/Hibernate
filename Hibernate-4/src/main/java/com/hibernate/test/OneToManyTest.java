package com.hibernate.test;

import org.hibernate.Session;

import com.concretepage.HibernateUtil;
import com.hibernate.entities.Department;
import com.hibernate.entities.Employee;
import com.hibernate.entities.Student;

public class OneToManyTest {

	public static void main(String[] args) {
		
		save();
		
		delete();
		
		HibernateUtil.getSessionFactory().close();
	}

	private static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		/*Department department = new Department();
		department.setId(1);
		session.beginTransaction();
		session.delete(session.load(Department.class,1));
		session.getTransaction().commit();*/
		
		Employee employee = new Employee();
		employee.setId(1);
		session.beginTransaction();
		//session.delete(employee);
		session.delete(session.load(Employee.class, 1));
		session.getTransaction().commit();
		session.close();
	}

	private static void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Department department = new Department();
		department.setName("DCSA");
		
		Employee employee = new Employee();
		employee.setName("Bharat");
		employee.setDepartment(department);
		
		department.getEmployees().add(employee);
		
		employee = new Employee();
		employee.setName("Bharat");
		employee.setDepartment(department);
		
		department.getEmployees().add(employee);
		
		session.persist(department);
		
		session.flush();
		
		session.close();
	}

}
