package com.jumia.app.dto;

import com.jumia.app.enums.StatesEnum;

public class CustomerDTO {
	public Integer id;
	public String countryName;
	public Enum<StatesEnum> countryState;
	public Integer countryCode;
	public String phoneNumber;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Enum<StatesEnum> getCountryState() {
		return countryState;
	}

	public void setCountryState(Enum<StatesEnum> countryState) {
		this.countryState = countryState;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", countryName=" + countryName + ", countryState=" + countryState
				+ ", countryCode=" + countryCode + ", phoneNumber=" + phoneNumber + "]";
	}
	

}
