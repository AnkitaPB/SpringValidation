package com.bo;

import java.sql.SQLException;

import com.bean.Bank;
import com.bean.PersonalVO;
import com.exception.MySpringException;

public interface BankBO {

	void insertBankDetail(Bank bank, PersonalVO personalVO)
			throws ClassNotFoundException, SQLException, MySpringException;

}