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
import com.newlecture.web.service.DefaultMenuService;
import com.newlecture.web.service.MenuService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menu/list3")
public class ListController3 extends HttpServlet{

	// 멤버 변수 생성 - service 인터페이스
	private MenuService service;
	
	// 생성자 함수 생성 - 멤버 변수 초기화 
	public ListController3() {
		service = new DefaultMenuService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 클라이언트에게 보내는 페이지에 출력할수 있는 객체 생성
		PrintWriter out = resp.getWriter();
		
		// 페이지의 포맷 방식 알려 주기
		resp.setContentType("text/html; charset=utf-8");
		
		// 클라이언트에게 보낼 데이터 양식 보내기
//		List<Menu> menus = service.getList();
		
		List<Menu> menus = new ArrayList<>();
		
//		HttpSession session = req.getSession();
//		session.setAttribute("haha", "hoho");
		
		Cookie cookie = new Cookie("haha1","cookie-hoho");
		cookie.setPath("/");
		cookie.setMaxAge(60*24); // 하루동안
		resp.addCookie(cookie);
		
		
		req.setAttribute("menus", menus);
		req.getRequestDispatcher("/WEB-INF/view/menu/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String rename = req.getParameter("rename");
//		
//		service.changeName(rename);
//		
//		resp.sendRedirect("/menu/list3");
//		super.doPost(req, resp);
	}
}