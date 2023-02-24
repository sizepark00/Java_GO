package com.newlecture.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/cnt")
public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.printf("hello\n");
		out.print("sizepark");
		
//		String query = "";
		String sql = String.format("select * from member") ;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@portfo_high?TNS_ADMIN=D:/Tools/smart-wallet/Wallet_Portfo";
			Connection con = DriverManager.getConnection(url, "admin", "123456789aA@");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"UTF-8\">");
			out.write("<title>Insert title here</title>");
			out.write("</head>");
			out.write("<body>");
			out.write("	<h1>메뉴 목록</h1>");
			out.write("	<table>");
			out.write("		<tr>");
			out.write("		<td>번호</td>");
			out.write("		<td>이름</td>");
			out.write("		<td>가격</td>	");	
			out.write("	</tr>");
//			System.out.println(rs.get);
			
			// 필터링, 집계, 정렬
			while(rs.next())	// 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nicName = rs.getString("nicname");
				
				//out.println("<table>");
				//out.println("<tr>");
//				String format = String.format("id:%d, name:%s, nicname:%s\n" , id, name, nicName);
				//out.println(format);
//				out.println("</tr>");
//				out.println("</table>");
					
						
				out.write("<tr>");	
				out.write("	<td>"+id+"</td>");	
				out.write("	<td>" + name +"</td>");	
				out.write("	<td>5000</td>");				
				out.write("</tr>");							
					
			}
//			
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.write("</table>");	
		out.write("</body>");	
		out.write("</html>");	
		
	}
}
