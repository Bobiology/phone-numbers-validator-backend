package com.jumia.services.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.services.dao.CustomerDAO;
import com.jumia.services.model.Customer;
import com.jumia.services.repo.CustomerRepository;

@Service
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Collection<Customer> listAll() {
		
		return (Collection<Customer>) customerRepository.findAll();
	}
	
}
