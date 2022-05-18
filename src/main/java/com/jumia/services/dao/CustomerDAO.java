package com.jumia.services.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jumia.services.model.Customer;

public interface CustomerDAO {
	
	public Page<Customer> listAll(Pageable pageable);

}
