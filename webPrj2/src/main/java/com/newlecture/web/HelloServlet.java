package com.newlecture.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
//		PrintStream out = new PrintStream(response.getOutputStream());

//		서버가 클라이언트로 보내는 코드들이 utf-8이라는 뜻 (기본이 utf-8로 간다), 과거버젼 톰캣이면 설정해줘야 한다. 톰캣 10에서는 안 해줘도 된다.
		response.setCharacterEncoding("uft-8");
		
		//uft-8로 읽으라고 브라우져에게 알려주는 것이다.
		response.setContentType("text/html; charset=utf-8");
		String c = request.getParameter("c");
		
		int count = 10;
		
		if (c != null)
			count = Integer.parseInt(c);
		

		for (int i = 0; i < count; i++)
			out.println("안녕하세요 servlet");
	}
}
