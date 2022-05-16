package com.jumia.services.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<Collection<CustomerDTO>> listAll(){
		System.out.println(" Get All Phone numbers ");
		var customerList = customerService.listAll();
		return ResponseEntity.status(HttpStatus.OK).body(customerList);
	}
}
