package com.jumia.services.dto;

import com.jumia.services.model.StatesEnum;

public class CustomerDTO {
	public String countryName;
	public Enum<StatesEnum> countryState;
	public Integer countryCode;
	public Integer phoneNumber;

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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerDTO [countryName=" + countryName + ", countryState=" + countryState + ", countryCode="
				+ countryCode + ", phoneNumber=" + phoneNumber + "]";
	}

}
