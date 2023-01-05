package com.phone.validator.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_details")
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String accountId;
	private String accountType;
	private String accountName;
	private String customerId;
	private String accountNumber;
	private double availableBalance;
	private double actualBalance;
	//Gate-keeper fields
	private String createdOn;
	private LocalDate createdAt;

}
