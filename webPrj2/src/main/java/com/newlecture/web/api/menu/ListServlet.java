package com.newlecture.web.api.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/menus")
public class ListServlet extends HttpServlet{
	
	static List<Menu> list;
	static {
		list = new ArrayList<Menu>();
		list.add(new Menu(1,"아메리카노", 4000, "",null));
		list.add(new Menu(2,"아이스 아메리카노", 4500, "",null));
		list.add(new Menu(3,"카페라테", 5000, "",null));
		list.add(new Menu(4,"아이스 카페라테", 5500, "",null));
		list.add(new Menu(5,"카페모카", 5000, "",null));
		list.add(new Menu(6,"아이스 카페모카", 5500, "",null));
	}
	
	public ListServlet () {
		
	}
	
	// 메뉴 목록 : GET /admin/menus?q=new&p=1&s=15
	// 1번 메뉴 : GET /admin/menus/1 (쿼리스트링이 아닌 경로명이다)
	// 3번 메뉴 지워줘 : DELETE /admin/menus/3 <-> /admin/menus/3/del (SSR 방식, 예전 방식)
	// 메뉴 하나 생성해줘, 메뉴내용 전달 : POST 요청 /admin/menus
	// 3번 메뉴 내용 이걸로 수정해줘 : PUT 요청 /admin/menus/3
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 리플렉션, 어노테이션
		String json = "{";
		for(Menu m : list)
				json += "";
	}
}
