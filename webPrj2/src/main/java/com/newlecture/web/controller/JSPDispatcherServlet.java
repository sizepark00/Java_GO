package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.SQLException;

import com.newlecture.web.controller.menu.DetailPOJOController;
import com.newlecture.web.controller.menu.ListPOJOController4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class JSPDispatcherServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
//		String[] aa = {"12","34"};
//		
//		
//		out.printf("urI:%s\n",uri);
//		out.printf("urL:%s\n",url);
//		out.printf("hello print");
//		
		String viewSrc = "/WEB-INF/view/input.jsp";
//		
//		if(uri.equals("/menu/list")) 
//				viewSrc = new ListPOJOController4().requestHandler();
//		
//		if(uri.equals("/menu/detail"))
//				viewSrc = new DetailPOJOController().requestHandler();
//		
		
	
		try {
			Object controller = Class
					.forName("com.newlecture.web.controller.menu.ListPOJOController4")
					.getDeclaredConstructor()
					.newInstance();
			
			Class clsInfo = Class.forName("com.newlecture.web.controller.menu.ListPOJOController4");
			
			Class clsInfo1 = ListPOJOController4.class;
			
			Class clsInfo2 = controller.getClass();
			
			Method[] methods = clsInfo.getDeclaredMethods();
		
			Method method = null;
			
			for(Method m : methods) {
				if(m.getName().equals("requestHandler"))
					method = m;
			}
			
			Parameter[] params = method.getParameters();
			
			for(Parameter p : params) {
				System.out.printf("param : %s\n",p.getType().toString());
				System.out.printf("name : %s\n",p.getName());
			}
			int paramSize = method.getParameterCount();
			System.out.printf("param size : %d\n", paramSize);
			
			Object[] args = {"size", "park"};
			
//			for(int i = 0; i<paramSize; i++) {
//				args[i] =  
//			}
//			
			viewSrc = (String) method.invoke(controller, args );
//			String result = (String) method.invoke(controller, "size", "park" );
			System.out.printf("result : %s\n",viewSrc);
			
			
			
		}  catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req
		.getRequestDispatcher(viewSrc)
		.forward(req, resp);
		
		
		// /menu/list 요청이 오면
		// ListPOJOController의 requestHandler() 사용
		
		// /menu/derail 요청이 오면
		// DetailPOJOController의 requestHandler() 사용

	}

}
