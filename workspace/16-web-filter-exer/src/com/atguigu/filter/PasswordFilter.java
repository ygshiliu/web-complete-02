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
 * 对密码进行过滤
 * Servlet Filter implementation class PasswordFilter
 */
public class PasswordFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		//获取密码
		String password = req.getParameter("password");
		//对密码进行判断
		if("123456".equals(password)){
			//正确就放行，调用目标资源
			chain.doFilter(req, resp);
		}else{
			//否则拦截，返回login.jsp
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}
	
}