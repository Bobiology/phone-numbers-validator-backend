package com.phone.validator.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.validator.dao.CustomerDAO;
import com.phone.validator.model.Customer;
import com.phone.validator.repo.CustomerRepository;


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
