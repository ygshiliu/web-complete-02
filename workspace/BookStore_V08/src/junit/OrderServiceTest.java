package junit;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

/**
 * 文件名: OrderServiceTest.java
 * 描述: OrderService测试类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午8:16:51
 */
public class OrderServiceTest {
	private OrderService os = new OrderServiceImpl();
	@Test
	public void testCreateOrder() {
		User user = new User(1, "刘在石", "123123", "lizaishi@163.com");
		Cart cart = new Cart();
		cart.addBook2Cart(new Book(11, "Tomcat与JavaWeb开发", "孙卫琴", 79.5, 100, 100));
		cart.addBook2Cart(new Book(11, "Tomcat与JavaWeb开发", "孙卫琴", 79.5, 100, 100));
		
		String id = os.createOrder(user, cart);
		System.out.println(id);
	}

}
