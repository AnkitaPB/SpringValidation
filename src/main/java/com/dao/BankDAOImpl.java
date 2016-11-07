package com.dao;

import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Bank;
import com.bean.PersonalVO;
@Repository
public class BankDAOImpl implements BankDAO  {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public void insertBankDetail(Bank b,PersonalVO personalVO) throws ClassNotFoundException, SQLException
	{
		final String INSERT_BANK_QUERY="insert into bank(bname,accno,ssn,pid) values(?,?,?,?)";
		int pk=getPrimaryKey(personalVO);
		Object[] o=new Object[4];
		o[0]=b.getBankName();
		o[1]=b.getAccountNumber();
		o[2]=b.getSsn();
		o[3]=pk;
		this.jdbcTemplate.update(INSERT_BANK_QUERY, o);
	}
	
	public int getPrimaryKey(PersonalVO pb) throws ClassNotFoundException, SQLException
	{
		final String PRIMARY_KEY_QUERY="select pid from personal where fname=? and mname=? and lname=? and gender=?";
		int primaryKey=jdbcTemplate.queryForInt(PRIMARY_KEY_QUERY);
		return primaryKey;
		
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
