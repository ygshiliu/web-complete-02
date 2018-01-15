package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 1.写一个类实现Servlet接口
 * 2.在web.xml中进行注册
 * @author Administrator
 *
 */
public class AServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

			/**
			 * ServletConfig:
			 * 【代表】每一个servlet类都有它唯一对应的servletConfig对象，
			 * 		而ServletConfig对象就是用来封装我们在web.xml中配置的servlet标签中的信息
			 * 【获取】此对象由servlet容器创建，并将对象作为参数传递给init()方法，我们可以直接使用
			 * 【功能】
			 * 		1.可以用来获取servlet的别名
			 * 		2.获取servlet的初始化参数
			 * 		3.可以用来获取最大的一个域对象ServletContext
			 * 	
			 */
		
		//1.可以用来获取servlet的别名
		String name = config.getServletName();
		System.out.println(name);
		
		//2.获取servlet的初始化参数
		String value = config.getInitParameter("username");
		System.out.println(value);
		
		//3.可以用来获取最大的一个域对象ServletContext
		//servletContext：每个web应用有且仅有一个servletContext,主要用来在不同的web资源中共享数据
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext);

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
