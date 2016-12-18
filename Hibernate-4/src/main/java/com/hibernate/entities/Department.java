package com.hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
	@Id
	@GenericGenerator(name = "custom", strategy = "increment")
	@GeneratedValue(generator = "custom")
	@Column(name = "DEPARTMENT_ID")
	private int id;

	@Column(name = "DEPARTMENT_NAME")
	private String name;

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="department")
	//@JoinTable(name = "JOIN_TABLE", inverseJoinColumns = @JoinColumn(name = "EMP_ID"), joinColumns = @JoinColumn(name = "DEPT_ID"))
	private List<Employee> employees = new ArrayList<>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
