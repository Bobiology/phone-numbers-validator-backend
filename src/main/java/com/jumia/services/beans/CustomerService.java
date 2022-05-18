package com.jumia.services.beans;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jumia.services.dto.CustomerDTO;

public interface CustomerService {
	public Page<CustomerDTO> listAll(Pageable pageable);
}
