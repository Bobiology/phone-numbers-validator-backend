package com.jumia.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jumia.app.dao.CustomerDAO;
import com.jumia.app.model.Customer;
import com.jumia.app.repo.CustomerRepository;

@Service
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> listAll() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

}
