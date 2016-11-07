package com.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bean.Bank;
import com.bean.PersonalVO;
import com.dao.BankDAO;
import com.exception.MySpringException;
import com.validtor.Validator;

public class BankBOImpl implements BankBO {
    @Autowired
	private Validator validator;
	@Autowired
    private BankDAO bankDAO;
	public BankDAO getBankDAO() {
		return bankDAO;
	}
	public void setBankDAO(BankDAO bankDAO) {
		this.bankDAO = bankDAO;
	}
	
	public Validator getValidator() {
		return validator;
	}
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	@Override
	public void insertBankDetail(Bank bank, PersonalVO personalVO)
			throws ClassNotFoundException, SQLException, MySpringException {
		String err="";
		err=validator.bankValidator(bank);
		if(err.trim().length()==0 || err =="")
		{
		
			bankDAO.insertBankDetail(bank, personalVO);
		}
		else
		{
			throw new MySpringException(err);
		}// TODO Auto-generated method stub
		
	}
	

}
