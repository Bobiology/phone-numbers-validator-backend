package com.jumia.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumia.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
