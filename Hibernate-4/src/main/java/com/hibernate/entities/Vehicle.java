package com.hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	@Id
	@GenericGenerator(name="increment",strategy="increment")
	@GeneratedValue(generator="increment")
	@Column(name="VEHICLE_ID")
	private int id;
	@Column(name="VEHICLE_TYPE")
	@Access(value=AccessType.PROPERTY)
	private String type;
	
	@ManyToMany(mappedBy="vehicles",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@Column(name="USERS")
	private List<User> users = new ArrayList<>();
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
