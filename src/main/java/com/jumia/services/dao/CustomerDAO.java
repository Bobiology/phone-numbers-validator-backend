package com.jumia.services.dao;

import java.util.Collection;

import com.jumia.services.model.Customer;

public interface CustomerDAO {
	
	public Collection<Customer> listAll();

}
