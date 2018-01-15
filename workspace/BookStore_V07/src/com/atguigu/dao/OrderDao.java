package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Order;

/**
 * 文件名: OrderDao.java
 * 描述: 操作订单数据库表
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午4:50:25
 */
public interface OrderDao {
	
	/**
	 * 保存订单
	 * @param order
	 * @return
	 */
	int saveOrder(Order order);
	/**
	 * 修改订单状态
	 * @param orderId
	 * @param state
	 * @return
	 */
	int updateState(String orderId,int state);
	/**
	 * 根据用户id查询所有的订单信息，提供给客户使用
	 * @param userId
	 * @return
	 */
	List<Order> getOrderListByUserId(String userId);
	/**
	 * 查询所有的订单信息，提供给管理者使用
	 * @return
	 */
	List<Order> getOrderList();

}
