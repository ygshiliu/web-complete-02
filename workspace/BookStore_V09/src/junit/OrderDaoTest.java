package junit;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.imp.OrderDaoImpl;

/**
 * 文件名: OrderDaoTest.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午7:11:18
 */
public class OrderDaoTest {
	
	private OrderDao od = new OrderDaoImpl();
	@Test
	public void testSaveOrder() {
		String id = System.currentTimeMillis()+""+1;
		Order order = new Order(id, new Date(), 0, 200.0,10, 1);
		int count = od.saveOrder(order);
		System.out.println(count);
	}

	@Test
	public void testUpdateState() {
		od.updateState("14900085937401", 1);
	}

	@Test
	public void testGetOrderListByUserId() {
		List<Order> list = od.getOrderListByUserId("1");
		System.out.println(list);
	}

	@Test
	public void testGetOrderList() {
		List<Order> list = od.getOrderList();
		System.out.println(list);
	}

}
