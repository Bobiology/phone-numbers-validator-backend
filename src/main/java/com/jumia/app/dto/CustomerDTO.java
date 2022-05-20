package com.jumia.app.dto;

import com.jumia.app.enums.StatesEnum;

public class CustomerDTO {
	public Integer id;
	public String countryName;
	public Integer countryCode;
	public String phoneNumber;
	public Enum<StatesEnum> phoneStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
	public Enum<StatesEnum> getPhoneStatus() {
		return phoneStatus;
	}
	public void setPhoneStatus(Enum<StatesEnum> phoneStatus) {
		this.phoneStatus = phoneStatus;
	}
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", countryName=" + countryName + ", countryCode=" + countryCode
				+ ", phoneNumber=" + phoneNumber + ", phoneStatus=" + phoneStatus + "]";
	}
	
	
}
