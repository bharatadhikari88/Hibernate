package com.hibernate.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.OnDelete;

@Entity
/** base table, child table and child hold id of base **/
//@Inheritance(strategy=InheritanceType.JOINED)

/** Single Base table, @DiscriminatorColumn tells the child class name **/
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

/** base table,child table . base fields are duplicated in child table **/
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Base {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	private String baseField;
	
	private String field2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBaseField() {
		return baseField;
	}

	public void setBaseField(String baseField) {
		this.baseField = baseField;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	
}
