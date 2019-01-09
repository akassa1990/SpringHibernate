package com.akassa.SpringHibernateDemo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akassa.SpringHibernateDemo.model.Customer;
import com.akassa.SpringHibernateDemo.service.ICustomerService;

@RestController
public class HomeController {

	@Autowired
	ICustomerService customerService;
	
	// Returning booleam from Hibernate
	@GetMapping("api/customerexistName/{name}")
	public boolean customerExist(@PathVariable String name) {
		System.out.println("Inside Controller customerExist() Method.");
		return this.customerService.existsByName(name);

	}
	
	@GetMapping("api/customerexistId/{id}")
	public boolean customerExistByID(@PathVariable Long id) {
		System.out.println("Inside Controller customerExist() Method.");
		//return this.customerService.customerExistByID(id);
		return this.customerService.existsById(id);

	}
	
	@GetMapping("api/customerexistByIdAndName/{id}/{name}")
	public boolean customerExistByIdAndName(@PathVariable Long id, @PathVariable String name) {
		System.out.println("Inside Controller customerExist() Method.");
		//return this.customerService.customerExistByID(id);
		return this.customerService.existByIdAndName(id, name);

	}

	@GetMapping("api/customers")
	public List<Customer> findAll() {
		return this.customerService.findAll();
	}

	@DeleteMapping("api/customer/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		try {
			this.customerService.deleteById(id);
			return "Deleted Customer with ID: " + id;
		} catch (Exception e) {
			return "Operation not succesful!";
		}

	}

	@GetMapping("api/customers/{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		System.out.println("Inside Controller findById() Method.");
		return this.customerService.findById(id);

	}
/*	@GetMapping("query/customers")
	public List<Customer> listCustomers() {
		
		// TODO session
		Query query = session.createQuery("from Customer");
		return null;	
	}*/
}
