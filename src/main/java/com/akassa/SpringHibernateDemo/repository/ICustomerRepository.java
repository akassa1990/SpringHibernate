package com.akassa.SpringHibernateDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.akassa.SpringHibernateDemo.model.Address;
import com.akassa.SpringHibernateDemo.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByName(String name);
	public List<Customer> findByAddress(Address address);
	// Returning boolean
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.name = :name")
    boolean existsByName(@Param("name") String name);
	// Similar to existById
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.id = :id")
    boolean customerExistByID(@Param("id") Long id);
	// ExistByIdAndName
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.id = :id AND c.name = :name")
    boolean existByIdAndName(@Param("id") Long id, @Param("name") String name);
}