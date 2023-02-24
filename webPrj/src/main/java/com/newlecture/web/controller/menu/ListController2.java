package com.newlecture.web.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.MenuService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu/list2")
public class ListController2 extends HttpServlet{
	
	private MenuService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print("hello");
		
		String query = "";
		String sql = String.format("select * from member") ;
		List <Menu> menus = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
			Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			// 필터링, 집계, 정렬
			while(rs.next())	// 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date regDate = rs.getDate("reg_date");
				Menu menu = new Menu(id , name, 10000, "",regDate);
				menu.setImages("pic1.png,pic2.png,pic3.png,pic4.png,pic5.png");
				menus.add(menu);
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		req.setAttribute("menus",menus);
//		resp.sendRedirect("https://www.naver.com");
		req
		.getRequestDispatcher("/WEB-INF/view/menu/list.jsp")
		.forward(req, resp);
		
		
		//페이지 저장소 	:	PageContext
		//리퀘스트 저장소 :	HttpServletRequest
		//세션,		:	HttpSession
		//어플리케이션	:	ServletContext
		//
		//
		//
	}
}