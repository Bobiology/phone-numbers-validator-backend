package com.phone.validator.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phone.validator.dto.CustomerDTO;

public interface CustomerService {
	public Page<CustomerDTO> listAll(Pageable pageable);
}
