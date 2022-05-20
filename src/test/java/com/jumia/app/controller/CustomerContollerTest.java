package com.jumia.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jumia.app.controllers.CustomerController;
import com.jumia.app.exception.JumiaInternalErrorException;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerContollerTest {
	@Mock
	CustomerController customerController;
		
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void customerControllerWhenFetchingCountryPhoneNumbersRespondWithStatusCode200() {
		String uri = "/customers";
		MvcResult mvcResult = null;
		try {
			mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
					.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			
		} catch (Exception e) {
			throw new JumiaInternalErrorException();
		}
				
	}
	@Test
	public void evaluatesPageableParameter() {
		try {
			mockMvc.perform(get("/customers")
					.param("page", "2")
					.param("size", "20")
					.param("sort", "id,desc")
					.param("sort", "phone,asc"))
					.andExpect(status().isOk());
		} catch (Exception e) {
			throw new JumiaInternalErrorException();
		}
		
	}
}
