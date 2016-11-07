package com.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.bean.Address;
import com.bean.PersonalVO;
import com.dao.AddressDAO;
import com.exception.MySpringException;
import com.validtor.Validator;

public class AddressBOImpl implements AddressBO {
	@Autowired
	private AddressDAO addressDAO=null;

	@Override
	public void insertAddress(PersonalVO pb, Address address) throws Exception {
		addressDAO.insertAddreess(pb, address);
	}
	
}
