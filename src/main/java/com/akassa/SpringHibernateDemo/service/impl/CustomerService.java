package com.akassa.SpringHibernateDemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akassa.SpringHibernateDemo.model.Address;
import com.akassa.SpringHibernateDemo.model.Customer;
import com.akassa.SpringHibernateDemo.repository.ICustomerRepository;
import com.akassa.SpringHibernateDemo.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerRepositry;
	
	@Override
	public List<Customer> findAll(){
		return this.customerRepositry.findAll();
	}
	@Override
	public Optional<Customer> findById(Long id){
		return this.customerRepositry.findById(id);
	}
	@Override
	public Customer findByName(String name) {
		return this.customerRepositry.findByName(name);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Customer save(Customer cust) {
		return this.customerRepositry.save(cust);
	}
	@Override
	public List<Customer> findByAddress(Address address){
		return this.customerRepositry.findByAddress(address);
	}
	@Override
	public void deleteById(Long id) {
		this.customerRepositry.deleteById(id);
		
	}
	@Override
	public boolean existsByName(String name) {
		return this.customerRepositry.existsByName(name);
	}
	
	@Override
	public boolean customerExistByID(Long id) {
		System.out.println("Hi...");
		//return this.customerRepositry.customerExistByID(id);
		return this.customerRepositry.existsById(id);
	}
	@Override
	public boolean existsById(Long id) {
		return this.customerRepositry.existsById(id);
	}
	@Override
	public boolean existByIdAndName(Long id, String name) {
		// TODO Auto-generated method stub
		return this.customerRepositry.existByIdAndName(id, name);
	}
	
}
