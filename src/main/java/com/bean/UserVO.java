package com.bean;

import java.io.Serializable;

public class UserVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PersonalVO personalVO;
	private Bank bankVO;
	private Address addressVO;
	public PersonalVO getPersonalVO() {
		return personalVO;
	}
	public void setPersonalVO(PersonalVO personalVO) {
		this.personalVO = personalVO;
	}
	public Bank getBankVO() {
		return bankVO;
	}
	public void setBankVO(Bank bankVO) {
		this.bankVO = bankVO;
	}
	public Address getAddressVO() {
		return addressVO;
	}
	public void setAddressVO(Address addressVO) {
		this.addressVO = addressVO;
	}
	

}
