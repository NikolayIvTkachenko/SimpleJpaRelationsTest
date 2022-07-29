package com.rsh.testrelationtable.trt01.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	
	//ManyToMany
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_item",
			joinColumns = {@JoinColumn(name = "customer_fk")},
			inverseJoinColumns = {@JoinColumn(name = "item_fk")})
	private Set<Item> itemsManyToMany = new HashSet<Item>();
	
	
	
	//OneToMany
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerOneTMany")	
	//@JoinColumn(name = "customer_id")
	private List<Item> itemsOneToMany = new ArrayList<>();
	
	
	
	//OneToOne
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

	public List<Item> getItemsOneToMany() {
		return itemsOneToMany;
	}

	public void setItemsOneToMany(List<Item> itemsOneToMany) {
		this.itemsOneToMany = itemsOneToMany;
	}

	public Set<Item> getItemsManyToMany() {
		return itemsManyToMany;
	}

	public void setItemsManyToMany(Set<Item> itemsManyToMany) {
		this.itemsManyToMany = itemsManyToMany;
	}
	
	
	

}
