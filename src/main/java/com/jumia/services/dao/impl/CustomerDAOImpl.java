package com.jumia.services.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jumia.services.dao.CustomerDAO;
import com.jumia.services.model.Customer;
import com.jumia.services.repo.CustomerRepository;

@Service
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Page<Customer> listAll(Pageable pageable) {
		Page<Customer> customers = customerRepository.findAll(pageable);
		return customers;
	}

}
