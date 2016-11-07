package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommanDAO {

    String  url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String  user = "root";
   String   pass = "root";
   String   db = "user";
 
  Connection con;
  public Connection initConnection() throws ClassNotFoundException, SQLException{
               Class.forName(driver);
               con = DriverManager.getConnection(url+ db,user,pass);
               return con;
         
  }
}