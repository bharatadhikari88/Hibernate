package com.hibernate.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorColumn(name="Child1")
public class Child1 extends Base{
	
	private String child1Field;
	
	@Column(name="Chld1_Field2")
	private String field2;

	public String getChild1Field() {
		return child1Field;
	}

	public void setChild1Field(String child1Field) {
		this.child1Field = child1Field;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
	
	
}
