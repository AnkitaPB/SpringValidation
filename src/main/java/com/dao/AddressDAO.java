package com.dao;

import java.sql.SQLException;

import com.bean.Address;
import com.bean.PersonalVO;

public interface AddressDAO {

	void insertAddreess(PersonalVO pb, Address a) throws ClassNotFoundException, SQLException;

	int getPrimaryKey(PersonalVO pb) throws ClassNotFoundException, SQLException;

}