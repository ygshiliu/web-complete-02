package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CServlet extends MyGenericServlet {
	
	public void init() throws ServletException {
		System.out.println("Cservlet的无参init初始化操作");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		System.out.println("Cservlet被调用");
		//获取servletContext对象
		ServletContext context = getServletConfig().getServletContext();
		System.out.println(context);

	}

}
