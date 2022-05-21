package com.phone.validator.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.phone.validator.enums.StatesEnum;
import com.phone.validator.services.impl.CustomerServiceImpl;

class CustomerServiceImplTest {
	CustomerServiceImpl customer = new CustomerServiceImpl();
	
	String phonenumberWithCountryCode = "(237) 695539786"; //Cameroon
	String phoneNumberToken[] = phonenumberWithCountryCode.split("\\s+");

	@Test
	void testMapCustomerToCustomerDTO() {
		var dto = customer.mapCustomerToCustomerDTO("(256) 7771031454");
		
		assertEquals(256, dto.countryCode);
	}

	@Test
	void testGetPhoneNumberStateAndReturn_NOT_VALID() {
		var status = customer.getPhoneNumberState("(256) 7771031454", "Uganda");
		
		assertEquals(StatesEnum.NOT_VALID, status);
	}

	@Test
	void testGetPhoneNumberStateAndReturnVALID() {
		var status = customer.getPhoneNumberState("(251) 988200000", "Ethiopia");
		
		assertEquals(StatesEnum.VALID, status);
	}

	@Test
	void testGetPhoneNumber() {
		String phoneNo = customer.getPhoneNumber(phoneNumberToken);
		
		assertEquals("695539786", phoneNo);
	}
	
	@Test
	void testGetCountryCode() {
		Integer countryCode = customer.getCountryCode(phoneNumberToken);
		
		assertEquals(237, countryCode);
	}

	@Test
	void testGetCountryName() {
		String country = customer.getCountryName(237);
		
		assertEquals("Cameroon", country);
	}

}
