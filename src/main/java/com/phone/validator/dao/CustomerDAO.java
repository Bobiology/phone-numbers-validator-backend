package com.phone.validator.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phone.validator.model.Customer;

public interface CustomerDAO {
	
	public List<Customer> listAll();

}
