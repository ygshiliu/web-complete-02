package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WEBUtils;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bs = new BookServiceImpl();
	//显示图书列表 
	protected void findBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNoStr = request.getParameter("pageNo");
		String pageSizeStr = "4";
		
		Page<Book> page = bs.findBook(pageNoStr, pageSizeStr);
		
		//获取请求资源路径
		WEBUtils.setPath(request, page);
		
		//将page设置进域里
		request.setAttribute("page", page);
		
		//转发
		request.getRequestDispatcher("/pages/user/home.jsp").forward(request, response);
	}
	//显示图书列表 
	protected void findBookByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageSizeStr = "4";
		String pageNoStr = request.getParameter("pageNo");
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		
		Page<Book> page = bs.findBookByPrice(pageNoStr, pageSizeStr, min, max);
		
		//获取请求资源路径
		WEBUtils.setPath(request, page);
		
		//将page设置进域里
		request.setAttribute("page", page);
		
		//转发
		request.getRequestDispatcher("/pages/user/home.jsp").forward(request, response);
	}


}
