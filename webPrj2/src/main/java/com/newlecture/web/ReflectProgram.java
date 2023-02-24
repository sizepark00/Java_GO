package com.newlecture.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import com.newlecture.web.controller.menu.ListPOJOController4;

public class ReflectProgram {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

		Object controller = Class
				.forName("com.newlecture.web.controller.menu.ListPOJOController4")
				.getDeclaredConstructor()
				.newInstance();

//		ChatServer cs = Class.forName("com.newlecture.web.ChatServer").newInstance();
		
		Class clsInfo = Class.forName("com.newlecture.web.controller.menu.ListPOJOController4");
		
		Class clsInfo1 = ListPOJOController4.class;
		
		Class clsInfo2 = controller.getClass();
		
		Method[] methods = clsInfo.getDeclaredMethods();
		
		Method method = null;
		
		for(Method m : methods) {
			if(m.getName().equals("add"))
				method = m;
		}
		
		Parameter[] params = method.getParameters();
		int i = 0;
		for(Parameter p : params) {
			System.out.printf("param[%d] : %s\n",i,p.getType().toString());
			i++;
		}
		
//		int result = (int) method.invoke(controller, 10,4 );
				
//		System.out.printf("result : %d\n",result);

	}

}
