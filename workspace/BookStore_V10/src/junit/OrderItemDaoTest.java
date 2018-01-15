package junit;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.imp.OrderItemDaoImpl;

/**
 * 文件名: OrderItemDaoTest.java
 * 描述: 测试OrderItemDao实现 类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午7:30:40
 */
public class OrderItemDaoTest {
	private OrderItemDao oid = new OrderItemDaoImpl();

	@Test
	public void testSaveOrderItem() {
		OrderItem item = new OrderItem(1, "Tomcat与javaweb开发", "孙卫琴", 70, "static/img/default.jpg", 10, 700, "14900085937401");
		oid.saveOrderItem(item);
	}

	@Test
	public void testGetInfoByOrderId() {
		List<OrderItem> info = oid.getInfoByOrderId("14900085937401");
		System.out.println(info);
	}

}
