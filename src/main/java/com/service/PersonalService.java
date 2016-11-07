package com.service;

import com.bean.Address;
import com.bean.Bank;
import com.bean.PersonalVO;

public interface PersonalService {
	
	public void insertPersonalDetail(PersonalVO personalVO, Address addressVO, Bank bankVO)throws Exception;
}