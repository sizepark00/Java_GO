package com.newlecture.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProgram2 {

   public static void main(String[] args) throws ClassNotFoundException, SQLException {

      Class.forName("oracle.jdbc.driver.OracleDriver");

      String url = "jdbc:oracle:thin:@portfo_high?TNS_ADMIN=C:/Users/user/Desktop/Wallet_Portfo";
      Connection con = DriverManager.getConnection(url, "admin", "123456789aA@");
      
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select * from member");
      
      
    while(rs.next()) {
    	String nickName = rs.getString("nicname");
    	System.out.println(nickName);
    }
      con.close();

//      DriverManager
//      Connection
//      Statement
//      ResultSet
   }

}