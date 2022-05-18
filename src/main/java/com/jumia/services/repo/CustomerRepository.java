package com.jumia.services.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumia.services.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
