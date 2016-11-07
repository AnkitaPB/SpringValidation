package com.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Address;
import com.bean.PersonalVO;
@Repository
public class AddressDAOImpl implements AddressDAO {
    @Autowired	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Override
	public void insertAddreess(PersonalVO pb, Address a) throws ClassNotFoundException, SQLException
	{
		System.out.println("Address DAO Started...");
		final String INSERT_ADDRESS="insert into address (address,city,state,country,pincode,pid) values (?,?,?,?,?,?)";
		Object o[]=new Object[6];
		int p=getPrimaryKey(pb);
		o[0]=a.getAddress();
		o[1]=a.getCity();
		o[2]=a.getState();
		o[3]=a.getCountry();
		o[4]=a.getPinCode();
		o[5]=p;
		jdbcTemplate=new JdbcTemplate(dataSource);
				
		this.jdbcTemplate.update(INSERT_ADDRESS,o);
		System.out.println("AddressDAO Ended...");
	}
	public int getPrimaryKey(PersonalVO pb) throws ClassNotFoundException, SQLException
	{
		final String PRIMARY_KEY_QUERY="select pid from personal where fname=? and mname=? and lname=? and gender=?";
		jdbcTemplate=new JdbcTemplate(dataSource);
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
