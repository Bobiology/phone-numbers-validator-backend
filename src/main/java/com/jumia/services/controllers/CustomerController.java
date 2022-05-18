package com.jumia.services.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.services.beans.CustomerService;
import com.jumia.services.dto.CustomerDTO;
import com.jumia.services.exception.JumiaNoContentException;

@RequestMapping("customers")
@RestController
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(produces = {"application/json"})
	@GetMapping
	public ResponseEntity<Page<CustomerDTO>> listAll(Pageable pageable){
		LOGGER.info("Get All Phone numbers ");
		var customerList = customerService.listAll(pageable);
		
		if (customerList.getContent().isEmpty()) throw new JumiaNoContentException();
		
		return ResponseEntity.status(HttpStatus.OK).body(customerList);
	}
}
