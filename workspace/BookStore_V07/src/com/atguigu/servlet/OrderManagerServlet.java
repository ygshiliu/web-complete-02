package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

/**
 * 管理员处理订单的请求
 * Servlet implementation class OrderManagerServlet
 */
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderService os = new OrderServiceImpl();
	
	protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有订单
		List<Order> list = os.getOrderList();
		//设置进请求域
		request.setAttribute("list", list);
		//转发
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
		
	}

	//发货
	protected void sendBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String orderId = request.getParameter("orderId");
		//发货
		os.sendBook(orderId);
		//获取请求来源
		String referer = request.getHeader("referer");
		//重定向
		response.sendRedirect(referer);
		
	}
	
	protected void orderInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String orderId = request.getParameter("orderId");
		//获取当前订单的订单项
		List<OrderItem> list = os.getInfoByOrderId(orderId);
		//设置进域中
		request.setAttribute("list", list);
		//转发
		request.getRequestDispatcher("/pages/order/orderItem.jsp").forward(request, response);
		
		
	}
}
