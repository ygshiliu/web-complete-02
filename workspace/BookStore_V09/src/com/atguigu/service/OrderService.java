package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;

/**
 * 文件名: OrderService.java
 * 描述: 与订单相关的业务
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午7:36:40
 */
public interface OrderService {
	
	/**
	 * 生成订单
	 * @param user
	 * @param cart
	 * @return
	 */
	String createOrder(User user,Cart cart);
	/**
	 * 查询当前用户的所有订单
	 * @param userId
	 * @return
	 */
	List<Order> getOrderListByUserId(String userId);
	/**
	 * 查询所有订单，供管理员调用
	 * @return
	 */
	List<Order> getOrderList();
	/**
	 * 商家发货
	 * @param orderId
	 */
	void sendBook(String orderId);
	/**
	 * 买家确认收货
	 * @param orderId
	 */
	void takeBook(String orderId);
	/**
	 * 查询当前订单下的所有订单项
	 * @param orderId
	 * @return
	 */
	List<OrderItem> getInfoByOrderId(String orderId);
	
}
