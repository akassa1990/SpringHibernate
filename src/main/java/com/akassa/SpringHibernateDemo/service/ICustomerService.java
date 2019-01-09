package com.akassa.SpringHibernateDemo.service;

import java.util.List;
import java.util.Optional;

import com.akassa.SpringHibernateDemo.model.Address;
import com.akassa.SpringHibernateDemo.model.Customer;
import com.akassa.SpringHibernateDemo.repository.ICustomerRepository;

public interface ICustomerService {
	public List<Customer> findAll();
	public Optional<Customer> findById(Long id);
	public Customer findByName(String name);
	public void deleteById(Long id);
	@SuppressWarnings("unchecked")
	public Customer save(Customer cust);
	public List<Customer> findByAddress(Address address);
	// Returning boolean
	public boolean existsByName(String name);
	public boolean customerExistByID(Long id);
	public boolean existsById(Long id);
	public boolean existByIdAndName(Long id, String name);
	
}
