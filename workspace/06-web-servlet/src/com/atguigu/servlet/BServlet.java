package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BServlet implements Servlet {
	
	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		/**
		 * ServletContext:
		 * 【代表】web应用的所有信息都都封装在servletContext对象中，每个web应用有且仅有一个ServletContext对象
		 * 		它是在项目启动时创建，在项目卸载时销毁
		 * 【获取】可以通过 servletConfig对象获取 
		 * 【功能】
		 * 		1.可以用来获取初始化参数
		 * 		<context-param>
					<param-name>encoding</param-name>
					<param-value>utf-8</param-value>
				</context-param>
				2.可以用来获取资源在服务器上的物理路径
					虚拟路径：http://localhost:8080/06-web-servlet/HelloServlet
					物理路径：D:\workspace\0205\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\06-web-servlet\index.html
				3.本身可以作为一个最大的域对象在不同的web资源中共享数据 
		 */
		
		
		//获取servletContext对象
		ServletContext servletContext = getServletConfig().getServletContext();
		//1.获取初始化参数
		String encode = servletContext.getInitParameter("encoding");
		//System.out.println(encode);
		
		//2.可以用来获取资源的物理路径
		//主要用来做文件的上传下载
		String path = servletContext.getRealPath("index.html");
		//System.out.println(path);
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
