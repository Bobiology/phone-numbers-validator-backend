package com.jumia.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jumia.app.enums.StatesEnum;
import com.jumia.app.services.impl.CustomerServiceImpl;

public class CustomerServiceTest {
	
	CustomerServiceImpl service = new CustomerServiceImpl();
	
	
	@Test
	public void checkIfPhoneNumberIsValidAndReturnVALID() {
		var status = service.getPhoneNumberState("(256) 7771031454", "Uganda");
		
		assertEquals(StatesEnum.NOT_VALID, status);
	}


}
