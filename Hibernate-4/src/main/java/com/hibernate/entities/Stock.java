package com.hibernate.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity()
@Table(name="STOCK",indexes={@Index(name="idx",columnList="STOCK_ID,STOCK_NAME"),
							@Index(name="stock_name_idx",columnList="STOCK_NAME")})
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region="temp")
@NamedQuery(name="Stock.byId",query="from Stock where id=2")
@Immutable //prevent update on this entity. Add and delete still allowed
public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STOCK_ID")
	private int id;
	//@Index(name="stock_name_idx")   //not allowed
	@Column(name="STOCK_NAME")
	private String name;
	
	@ElementCollection
	private List<String> stockCategories = new ArrayList<>();
	
	@ElementCollection
	private Map<String, Integer> testMap = new HashMap<>();
	
	
	public Map<String, Integer> getTestMap() {
		return testMap;
	}
	public void setTestMap(Map<String, Integer> testMap) {
		this.testMap = testMap;
	}
	public List<String> getStockCategories() {
		return stockCategories;
	}
	public void setStockCategories(List<String> stockCategories) {
		this.stockCategories = stockCategories;
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
