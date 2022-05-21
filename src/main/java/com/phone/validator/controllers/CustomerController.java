package com.phone.validator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.validator.dto.CustomerDTO;
import com.phone.validator.exception.JumiaNoContentException;
import com.phone.validator.services.CustomerService;

@RequestMapping("customers")
@RestController
public class CustomerController {
		
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(produces = {"application/json"})
	@GetMapping
	public ResponseEntity<Page<CustomerDTO>> listAll(Pageable pageable){
		//pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(
			    //Order.asc("countryName")
			    //,Order.desc("countryCode")
			    //));

		var customerList = customerService.listAll(pageable);
		
		if (customerList.getContent().isEmpty()) throw new JumiaNoContentException();
		
		return ResponseEntity.status(HttpStatus.OK).body(customerList);
	}

}
