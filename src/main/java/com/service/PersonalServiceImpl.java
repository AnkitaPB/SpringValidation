package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Address;
import com.bean.Bank;
import com.bean.PersonalVO;
import com.dao.PersonalDAO;

@Service("personalService")
@Transactional
public class PersonalServiceImpl implements PersonalService {
	
	@Autowired
	PersonalDAO personalDAO=null;
	
	@Override
	public void insertPersonalDetail(PersonalVO personalVO, Address addressVO, Bank bankVO) throws Exception {
		personalDAO.insertPersonalDetail(personalVO, addressVO, bankVO);

	}
	
		
}

	
	

