package com.jumia.services.beans;

import java.util.Collection;

import com.jumia.services.dto.CustomerDTO;

public interface CustomerService {
	public Collection<CustomerDTO> listAll();
}
