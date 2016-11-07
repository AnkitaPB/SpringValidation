package com.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class Bank implements Serializable {
	@NotBlank
	private String bankName;
	@NotBlank
	private String accountNumber;
	@NotBlank
	private String ssn;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	

}
