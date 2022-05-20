package com.jumia.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jumia.app.dto.CustomerDTO;

public interface CustomerService {
	public Page<CustomerDTO> listAll(Pageable pageable);
}
