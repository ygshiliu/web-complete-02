package com.atguigu.dao.imp;

import java.util.List;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;

/**
 * 文件名: OrderItemImpl.java
 * 描述: OrderItemDao实现类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午7:23:35
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public int saveOrderItem(OrderItem item) {
		String sql = "insert into bs_order_items(title,author,price,img_path,count,amount,order_id) "
				+ " values (?,?,?,?,?,?,?)";
		return update(sql, item.getTitle(),item.getAuthor(),item.getPrice(),item.getImgPath(),item.getCount(),item.getAmount(),item.getOrderId());
		
	}

	@Override
	public List<OrderItem> getInfoByOrderId(String orderId) {
		String sql = "select id,title,author,price,img_path imgPath,count,amount,order_id orderId from bs_order_items where order_id = ?";
		return getBeanList(sql, orderId);
		
	}

	@Override
	public int[] batchSave(Object[][] params) {
		String sql = "insert into bs_order_items(title,author,price,img_path,count,amount,order_id) "
				+ " values (?,?,?,?,?,?,?)";
		return batch(sql, params);
		
	}

}
