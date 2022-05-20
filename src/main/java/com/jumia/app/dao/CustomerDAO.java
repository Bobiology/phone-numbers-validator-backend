package com.jumia.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jumia.app.model.Customer;

public interface CustomerDAO {
	
	public List<Customer> listAll();

}
