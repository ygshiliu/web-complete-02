package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WEBUtils;

/**
 * 与购物车相关的请求
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bs = new BookServiceImpl();
	
	/**
	 * 添加图书到购物车中
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addBook2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取bookID
		String bookId = request.getParameter("bookId");
		//获取图书
		Book book = bs.getBook(bookId);
		
		//获取 Cart
		HttpSession session = request.getSession();
		Cart cart = WEBUtils.getCart(request);
		//将图书添加进购物车
		cart.addBook2Cart(book);
		
		//获取请求来源
		String referer = request.getHeader("referer");
		
		//获取图书名称放到域中
		session.setAttribute("title", book.getTitle());
		//重定向
		response.sendRedirect(referer);
	}
	//删除购物项
	protected void deleteCartItem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数 
		String bookId = request.getParameter("bookId");
		
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		
		//删除cartItem
		cart.deleteCartItem(bookId);
		
		//获取referer
		String referer = request.getHeader("referer");
		
		response.sendRedirect(referer);
	}
	
	//清空购物车
	protected void clear(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//获取Cart
		Cart cart = WEBUtils.getCart(request);
		//清空购物车
		cart.clear();
		//获取请求来源
		String referer = request.getHeader("referer");
		//重定向
		response.sendRedirect(referer);
		
	}
	
	//修改购物项数量
	protected void changeCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String bookId = request.getParameter("bookId");
		String countstr = request.getParameter("count");
		int count = Integer.parseInt(countstr);
		
		//获取Cart
		Cart cart = WEBUtils.getCart(request);
		
		cart.changeCount(bookId, count);
		
		//获取请求头
		String referer = request.getHeader("referer");
		
		//重定向
		response.sendRedirect(referer);
		
	}
}
