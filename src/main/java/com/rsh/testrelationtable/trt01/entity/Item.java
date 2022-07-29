package com.rsh.testrelationtable.trt01.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	

}
