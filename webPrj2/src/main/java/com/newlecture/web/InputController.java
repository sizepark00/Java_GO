package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 쿼리 스트링을 이용한 입력
		// 웹이 문서를 요청을 할떄 추가적으로 제공하게 되는 옵션값
		// 단. 서버에 따라 요청의 방법이 달라진다.

		PrintWriter out = resp.getWriter();

		String page = req.getParameter("p");
		String query = req.getParameter("q");
		String size = req.getParameter("s");
		resp.setContentType("text/html; charset=utf-8");
		// 2. form을 이용한 입력

		
		req.setAttribute("page", page);
		req.setAttribute("query", query);
		req.setAttribute("size", size);
		
		req.getHeader("referer");
		
//		String[] hbs = new String[3];
//		hbs = {"1","2","3"};
		
		String[] hbs = req.getParameterValues("hb");
		if(hbs != null)
			req.setAttribute("cnt", hbs.length);
		// 3. 쿠키 입력
		// 상태값을 확인하고 싶을떄 사용 -> 서비스 제공자가 사용자의 상태정보를 담는!?
		// 3-1. 세션 => 시간(기간)과 관련된 저장소, 허용된 기간
		
		// 4. Header 입력
		
		
		// 5. hidden 필드 입력

		req
		.getRequestDispatcher("/WEB-INF/view/input.jsp")
		.forward(req, resp);
	}

}
