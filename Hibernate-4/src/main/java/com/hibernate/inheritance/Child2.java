package com.hibernate.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="Child2")
public class Child2 extends Base{
	
	private String child2Field;
	


	public String getChild2Field() {
		return child2Field;
	}

	public void setChild2Field(String child2Field) {
		this.child2Field = child2Field;
	}
	
	
}
