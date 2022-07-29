package com.rsh.testrelationtable.trt01.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
	private Customer customer;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customerOneTMany;
	
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "itemsManyToMany")
	private Set<Customer> customerManyToMany = new HashSet<Customer>();
	
	
	public Item() {}
	
	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Set<Customer> getCustomerManyToMany() {
		return customerManyToMany;
	}

	public void setCustomerManyToMany(Set<Customer> customerManyToMany) {
		this.customerManyToMany = customerManyToMany;
	}
	
	

}
