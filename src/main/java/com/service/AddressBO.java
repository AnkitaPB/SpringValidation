package com.bo;

import com.bean.Address;
import com.bean.PersonalVO;

public interface AddressBO {

	void insertAddress(PersonalVO pb, Address address) throws Exception;

}