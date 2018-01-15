package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UsernameFilter
 */
public class UsernameFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//获取用户名
		String username = req.getParameter("username");
		//对用户名进行验证
		if("admin".equals(username)){
			//正确就放行
			chain.doFilter(req, resp);
		}else{
			//否则进行拦截重新返回登录页面
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}
	
}