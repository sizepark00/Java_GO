package com.newlecture.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;

public class JDBCProgram {

   public static void main(String[] args) throws ClassNotFoundException, SQLException {

      Class.forName("oracle.jdbc.driver.OracleDriver");
      
      String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
      Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
      
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select * from member where id>= 100");
      
      //필터링, 집계, 정렬
      while(rs.next()) {
    	int id = rs.getInt("id");
    	String name = rs.getString("name");
      	String nickName = rs.getString("nicname");
      	String format = String.format("id : %d, name: %s, nicName: %s\n", id, name, nickName);
      	System.out.print(format);
      }
//      System.out.println(con.isClosed());

      con.close();

//      DriverManager
//      Connection
//      Statement
//      ResultSet
   }
}