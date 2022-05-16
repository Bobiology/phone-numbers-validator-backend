package com.jumia.services.beans.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.services.Application;
import com.jumia.services.beans.CustomerService;
import com.jumia.services.dao.CustomerDAO;
import com.jumia.services.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public Collection<CustomerDTO> listAll() {

		Collection<CustomerDTO> customerDTO = new ArrayList<>();

		var customerList = customerDAO.listAll();

		customerList.forEach(customer -> {
			var phoneNumber = customer.getPhone();
			
			LOGGER.info("PhoneNumbers= " + phoneNumber);

		});

		return customerDTO;
	}

}
