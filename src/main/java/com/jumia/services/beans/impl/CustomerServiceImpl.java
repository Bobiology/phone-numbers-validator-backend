package com.jumia.services.beans.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jumia.services.Application;
import com.jumia.services.beans.CustomerService;
import com.jumia.services.dao.CustomerDAO;
import com.jumia.services.dto.CustomerDTO;
import com.jumia.services.model.CountriesMap;
import com.jumia.services.model.CountriesRegex;
import com.jumia.services.model.StatesEnum;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public Page<CustomerDTO> listAll(Pageable pageable) {

		List<CustomerDTO> list = new ArrayList<>();
		
		var customerList = customerDAO.listAll(pageable);

		customerList.forEach(customer -> {
			CustomerDTO customerDto = new CustomerDTO();
			
			var phoneNumberWithCountryCode = customer.getPhone();

			customerDto = mapCustomerToCustomerDTO(phoneNumberWithCountryCode);
			
			list.add(customerDto);

		});
		
		Page<CustomerDTO> pageableCustomerList = new PageImpl<>(list);

		return pageableCustomerList;
	}

	private CustomerDTO mapCustomerToCustomerDTO(String phoneNumberWithCountryCode) {
		
		CustomerDTO customerDto = new CustomerDTO();
		
		String[] phoneNumberTokens = splitBySpace(phoneNumberWithCountryCode);
		
		var countryCode = getCountryCode(phoneNumberTokens);
		var phoneNumber = getPhoneNumber(phoneNumberTokens);
		var countryName = getCountryName(countryCode);
		var state = getPhoneNumberState(phoneNumberWithCountryCode, countryName);
		
		LOGGER.info("COUNTRY CODE= " + countryCode + " PHONE NUMBER= " + phoneNumber + " COUNTRY NAME= " + countryName
				+ " STATE=" + state);
		
		customerDto.setCountryCode(countryCode);
		customerDto.setCountryName(countryName);
		customerDto.setCountryState(state);
		customerDto.setPhoneNumber(phoneNumber);
		
		return customerDto;
	}

	private boolean isValid(String phoneNumber, String countryName) {
		CountriesRegex regexMap = new CountriesRegex();

		var regex = regexMap.getRegexExpressions().get(countryName);

		return phoneNumber.matches(regex);
	}

	private Enum<StatesEnum> getPhoneNumberState(String phoneNumber, String countryName) {
		return isValid(phoneNumber, countryName) ? StatesEnum.VALID : StatesEnum.NOT_VALID;
	}

	private String[] splitBySpace(String phoneNumber) {

		return phoneNumber.split("\\s+");
	}

	private Integer getCountryCode(String[] phoneNumbers) {

		return Integer.valueOf(phoneNumbers[0].substring(1, 4));
	}

	private String getPhoneNumber(String[] phoneNumbers) {

		return phoneNumbers[1];
	}

	private String getCountryName(Integer countryCode) {

		CountriesMap map = new CountriesMap();

		return map.getCountries().getOrDefault(countryCode, null);
	}

}
