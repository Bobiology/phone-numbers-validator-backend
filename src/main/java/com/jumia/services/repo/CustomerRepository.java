package com.jumia.services.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jumia.services.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
}
