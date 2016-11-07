package com.dao;

import java.sql.SQLException;

import com.bean.Bank;
import com.bean.PersonalVO;

public interface BankDAO {

	void insertBankDetail(Bank b, PersonalVO p) throws ClassNotFoundException, SQLException;

}