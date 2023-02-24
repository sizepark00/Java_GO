package com.newlecture.web.controller.menu;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.DefaultMenuService;
import com.newlecture.web.service.MenuService;

import jakarta.servlet.http.HttpServletRequest;

// /menu/list
public class ListPOJOController4{

	// 멤버 변수 생성 - service 인터페이스
	private MenuService service;
	
	// 생성자 함수 생성 - 멤버 변수 초기화 
	public ListPOJOController4() {
		service = new DefaultMenuService();
	}
	
	public int add(int x, int y) {
		return x+y;
	}
	public String requestHandler(String id, String query) {
		
		return "/WEB-INF/view/menu/list.jsp";
	}
}