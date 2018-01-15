package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.OrderItem;

/**
 * 文件名: OrderItemDao.java
 * 描述: 操作订单项数据表
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午7:20:38
 */
public interface OrderItemDao {
	/**
	 * 保存订单项
	 * @param item
	 * @return
	 */
	int saveOrderItem(OrderItem item);
	/**
	 * 查询指定订单的所有订单项信息
	 * @param orderId
	 * @return
	 */
	List<OrderItem> getInfoByOrderId(String orderId);
	/**
	 * 批量保存订单项信息
	 * @param params
	 * @return
	 */
	int[] batchSave(Object[][] params);
}
