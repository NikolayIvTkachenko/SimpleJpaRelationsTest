package com.rsh.testrelationtable.trt01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;

import com.rsh.testrelationtable.trt01.entity.Customer;
import com.rsh.testrelationtable.trt01.entity.Item;
import com.rsh.testrelationtable.trt01.repository.CustomerRepository;
import com.rsh.testrelationtable.trt01.repository.ItemRepository;

@SpringBootApplication
public class Trt01Application implements Runnable{
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(Trt01Application.class, args);
	}
	


	@Override
	public void run() {
		Customer customer = new Customer("Nick");
		
		Item item = new Item("Item 01");
		customer.setItem(item);
		
		customerRepository.save(customer);
		
	}
	
}
