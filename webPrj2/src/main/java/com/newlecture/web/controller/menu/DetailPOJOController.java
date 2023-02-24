package com.newlecture.web.controller.menu;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.DefaultMenuService;
import com.newlecture.web.service.MenuService;

// /menu/detail
public class DetailPOJOController{

	// 멤버 변수 생성 - service 인터페이스
	private MenuService service;
	
	// 생성자 함수 생성 - 멤버 변수 초기화 
	public DetailPOJOController() {
		service = new DefaultMenuService();
	}
	
	public String requestHandler() {
		
		return "/WEB-INF/view/menu/detail.jsp";
	}
}