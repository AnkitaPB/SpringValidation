package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.Address;
import com.bean.Bank;
import com.bean.PersonalVO;

public class UserDAO {
	 final static  String USER_INSERT_QUERY=
   		  "insert into user (fname,mname,lname,gender,address,city,state,country,pincode,bankName,accNO,SSN)values(?,?,?,?,?,?,?,?,?,?,?,?)";
	 static Connection con;
      public Connection getConnection()throws SQLException, ClassNotFoundException
      {
    	  con=new CommanDAO().initConnection();
    	  return con;
      }
      public   void insertData(PersonalVO p,Address a,Bank b)throws SQLException
      {
    	    PreparedStatement ps = con.prepareStatement(USER_INSERT_QUERY);
    	    ps.setString(1, p.getFirstName());
			ps.setString(2, p.getMiddletName());
			ps.setString(3, p.getLastName());
			ps.setString(4, p.getGender());
			ps.setString(5, a.getAddress());
			ps.setString(6, a.getCity());
			ps.setString(7, a.getState());
			ps.setString(8, a.getCountry());
			ps.setString(9, a.getPinCode());
			ps.setString(10, b.getBankName());
			ps.setString(11, b.getAccountNumber());
			ps.setString(12, b.getSsn());
			int record = ps.executeUpdate();
			System.out.println("Record Inserted :"+record);
		
			
      }
}