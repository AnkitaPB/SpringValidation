package com.dao;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Address;
import com.bean.Bank;
import com.bean.PersonalVO;

@Repository
public class PersonalDAOImpl extends AbstractDAO implements PersonalDAO {
	    	
	@Autowired
	HibernateTemplate hibernateTemplate;


	@Override
	public void insertPersonalDetail(PersonalVO personalVO, Address addressVO, Bank bankVO) throws Exception {
                hibernateTemplate.save(personalVO);
    //            hibernateTemplate.save(addressVO);
      //          hibernateTemplate.save(bankVO);
	}

	

	/*private void createBank(Bank bankVO, PersonalVO personalVO) throws ClassNotFoundException, SQLException {
		final String INSERT_BANK_QUERY="insert into bank(bname,accno,ssn,pid) values(?,?,?,?)";
		Object[] o3=new Object[4];
		System.out.println("In create Bank:");
	
		int p=getPrimaryKey(personalVO);
		o3[0]=bankVO.getBankName();
		o3[1]=bankVO.getAccountNumber();
		o3[2]=bankVO.getSsn();
		o3[3]=p;
		jdbcTemplate=new JdbcTemplate(dataSource);
		this.jdbcTemplate.update(INSERT_BANK_QUERY, o3);

	}*/

 /*
	private void createAddress(Address addressVO,PersonalVO personalVO) throws ClassNotFoundException, SQLException {
		final String INSERT_ADDRESS="insert into address (address,city,state,country,pincode,pid) values (?,?,?,?,?,?)";
		Object o1[]=new Object[6];
		int p=getPrimaryKey(personalVO);
		System.out.println("aDDRESSvo:"+ addressVO.getAddress());
		o1[0]=addressVO.getAddress();
		o1[1]=addressVO.getCity();
		o1[2]=addressVO.getState();
		o1[3]=addressVO.getCountry();
		o1[4]=addressVO.getPinCode();
		o1[5]=p;				
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(INSERT_ADDRESS,o1);
	}
	*/


	
    

}
