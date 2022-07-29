package com.rsh.testrelationtable.trt01.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_item")
//	@JoinTable(name = "customer_item",
//			joinColumns = {@JoinColumn(name = "customer_id")},
//			inverseJoinColumns = { @JoinColumn(name = "iyem_id")})
	private Item item;
	

	public Customer(String name) {
		this.name = name;
	}
	
	public Customer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getId() {
		return id;
	}
	
	

}
