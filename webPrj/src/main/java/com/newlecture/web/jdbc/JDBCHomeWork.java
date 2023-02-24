package com.newlecture.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCHomeWork {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//사용자 입력을 받기위한 스캐너 준비
		Scanner sc = new Scanner(System.in);

		//사용자 입력 받기 위한 코드
		System.out.print("검색하실 회원이름 입력: ");
		String sName= sc.nextLine();
		
		//DB 연결을 위한 코드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
		Statement st = con.createStatement();
		
		// 실행하기 위한 SQL을 문자열 변수로 선언 where 조건문에 name= 조건식을 줘서 입력받은 이름으로 검색 진행
		// 이름값은 데이터 형태가 varchar2이므로 홀 따옴표로 묶어줘야 하기 때문에 \'로 sName을 감싸준다.
		String searchSQL = "select * from member where name=\'" + sName + "\'";
		
		//쿼리 실행
		ResultSet rs = st.executeQuery(searchSQL);
		//검색결과를 확인하기 위한 상태 변수 id가 -1인경우 이름이 일치하는 데이터가 없다고 판단
		int id =-1;
		
//		boolean once = true;
		while(rs.next()) {
//			if(once)
//				System.out.println("\n검색결과: ");
			id = rs.getInt("id");
			String name = rs.getString("name");
			String nicName = rs.getString("nicName");
			String format = String.format("id : %d, name: %s, nicName: %s\n", id, name, nicName);
			System.out.print(format);
//			once = false;
		}
		
		//검색 결과가 없을 경우 출력
		if(id == -1)
			System.out.println("일치하는 이름이 없습니다.");
		
		con.close();

//      DriverManager
//      Connection
//      Statement
//      ResultSet
	}
}