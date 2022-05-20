package com.jumia.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jumia.app.Application;
import com.jumia.app.dao.CustomerDAO;
import com.jumia.app.ds.CountriesMap;
import com.jumia.app.ds.CountriesRegex;
import com.jumia.app.dto.CustomerDTO;
import com.jumia.app.enums.StatesEnum;
import com.jumia.app.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public Page<CustomerDTO> listAll(Pageable pageable) {

		List<CustomerDTO> list = new ArrayList<>();

		var customerList = customerDAO.listAll();

		customerList.forEach(customer -> {
			CustomerDTO customerDto = new CustomerDTO();

			var phoneNumberWithCountryCode = customer.getPhone();

			customerDto = mapCustomerToCustomerDTO(phoneNumberWithCountryCode);
			customerDto.setId(customer.getId());
			list.add(customerDto);
		});

		return toPage(list, pageable);
	}

	private Page<CustomerDTO> toPage(List<CustomerDTO> list, Pageable pageable) {
		if (pageable.getOffset() >= list.size()) {
			return Page.empty();
		}
		int startIndex = (int) pageable.getOffset();
		int endIndex = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
				: pageable.getOffset() + pageable.getPageSize());

		List<CustomerDTO> phoneSubList = list.subList(startIndex, endIndex);
		return new PageImpl<>(phoneSubList, pageable, list.size());
	}

	public CustomerDTO mapCustomerToCustomerDTO(String phoneNumberWithCountryCode) {

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

	public Enum<StatesEnum> getPhoneNumberState(String phoneNumber, String countryName) {
		return isValid(phoneNumber, countryName) ? StatesEnum.VALID : StatesEnum.NOT_VALID;
	}

	private String[] splitBySpace(String phoneNumber) {

		return phoneNumber.split("\\s+");
	}

	public Integer getCountryCode(String[] phoneNumbers) {

		return Integer.valueOf(phoneNumbers[0].substring(1, 4));
	}

	public String getPhoneNumber(String[] phoneNumbers) {

		return phoneNumbers[1];
	}

	public String getCountryName(Integer countryCode) {

		CountriesMap map = new CountriesMap();

		return map.getCountries().getOrDefault(countryCode, null);
	}

}
