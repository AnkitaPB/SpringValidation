package com.validtor;

import com.bean.Address;
import com.bean.Bank;
import com.bean.PersonalInfo;

public interface Validator {

	boolean isDataEmpty(String data);

	String addressValidator(Address address);

	String personalValidator(PersonalInfo pb);

	String bankValidator(Bank b);

}