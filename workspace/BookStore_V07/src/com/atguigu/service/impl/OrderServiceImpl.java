package com.atguigu.service.impl;


import java.util.Date;
import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.imp.BookDaoImpl;
import com.atguigu.dao.imp.OrderDaoImpl;
import com.atguigu.dao.imp.OrderItemDaoImpl;
import com.atguigu.service.OrderService;

/**
 * 文件名: OrderServiceImpl.java
 * 描述: OrderService实现类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午7:38:32
 */
public class OrderServiceImpl implements OrderService {
	private OrderDao od = new OrderDaoImpl();
	private OrderItemDao oid = new OrderItemDaoImpl();
	private BookDao bd = new BookDaoImpl();

	@Override
	public String createOrder(User user, Cart cart) {

		//生成订单号，保存订单
		//订单号：时间戳+用户Id
		String id = System.currentTimeMillis()+""+user.getId();
		Order order = new Order(id, new Date(), 0, cart.getTotalAmount(), cart.getTotalCount(), user.getId());
		od.saveOrder(order);
		
		//保存订单项
		List<CartItem> list = cart.getList();
		
		//定义保存批量数据的变量
		Object[][] itemParams = new Object[list.size()][];
		Object[][] bookParams = new Object[list.size()][];
		
		for(int i=0 ;i<list.size();i++){
			//获取购物项
			CartItem cartItem = list.get(i);
			
			//获取订单项的具体信息
			Book book = cartItem.getBook();
			String title = book.getTitle();
			String author = book.getAuthor();
			double price = book.getPrice();
			String imgPath = book.getImgPath();
			int count = cartItem.getCount();
			double amount = cartItem.getAmount();
			
			//保存订单项数据：insert into bs_order_items(title,author,price,img_path,count,amount,order_id)
			itemParams[i]=new Object[]{title,author,price,imgPath,count,amount,id};
			
			//保存图书销量与库存：update bs_books set sale=?,stock=? where id=?
			bookParams[i]=new Object[]{book.getSale()+count, book.getStock()-count, book.getId()};
		}
		
		//进行批量操作
		oid.batchSave(itemParams);
		bd.batchUpdateSaleAndStock(bookParams);
		
		//清空购物车
		cart.clear();
		//返回订单号
		return id;
		
	}
/*	public String createOrder(User user, Cart cart) {
		
		//生成订单号，保存订单
		//订单号：时间戳+用户Id
		String id = System.currentTimeMillis()+""+user.getId();
		Order order = new Order(id, new Date(), 0, cart.getTotalAmount(), cart.getTotalCount(), user.getId());
		od.saveOrder(order);
		
		//保存订单项
		List<CartItem> list = cart.getList();
		for(int i=0 ;i<list.size();i++){
			//获取购物项
			CartItem cartItem = list.get(i);
			
			//获取订单项的具体信息
			Book book = cartItem.getBook();
			String title = book.getTitle();
			String author = book.getAuthor();
			double price = book.getPrice();
			String imgPath = book.getImgPath();
			int count = cartItem.getCount();
			double amount = cartItem.getAmount();
			
			//创建订单项
			OrderItem item = new OrderItem(null, title, author, price, imgPath, count, amount, id);
			oid.saveOrderItem(item);
			
			//修改库存与销量
			bd.updateStockAndSale(book.getSale()+count, book.getStock()-count, book.getId());
		}
		//清空购物车
		cart.clear();
		//返回订单号
		return id;
		
	}
*/
	@Override
	public List<Order> getOrderListByUserId(String userId) {
		return od.getOrderListByUserId(userId);
	}

	@Override
	public List<Order> getOrderList() {
		return od.getOrderList();
	}

	@Override
	public void sendBook(String orderId) {
		od.updateState(orderId, 1);
	}

	@Override
	public void takeBook(String orderId) {
		od.updateState(orderId, 2);
	}

	@Override
	public List<OrderItem> getInfoByOrderId(String orderId) {
		List<OrderItem> list = oid.getInfoByOrderId(orderId);
		return list;
	}

}
