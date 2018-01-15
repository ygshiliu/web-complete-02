package com.atguigu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Student;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//模拟从数据库中获取学生列表 
		List<Student> list = new ArrayList<>();
		list.add(new Student("宋智孝", "女", "昌平"));
		list.add(new Student("刘在石", "男", "通州"));
		list.add(new Student("李光洙", "男", "西城"));
		list.add(new Student("haha", "男", "海淀"));
		
		//将数据设置进域里，使用域对象的原则
		//能使用小的，就不使用大的
		//在servlet中只能获取 三个域对象，分别 是reqeust,session,application
		request.setAttribute("list", list);
		
		//需要转发到jsp页面中
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
