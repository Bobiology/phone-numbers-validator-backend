package com.jumia.services.controllers;

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

@RequestMapping("customers")
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(produces = {"application/json"})
	@GetMapping
	public ResponseEntity<Page<CustomerDTO>> listAll(Pageable pageable){
		System.out.println(" Get All Phone numbers ");
		var customerList = customerService.listAll(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(customerList);
	}
}
