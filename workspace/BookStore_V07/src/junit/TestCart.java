package junit;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;

/**
 * 文件名: TestCart.java
 * 描述: 测试购物车
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月17日 下午3:49:55
 */
public class TestCart {

	@Test
	public void test() {
		 Book book = new Book(1, "web开发", "孙卫琴", 10.05, 100, 100);
//		 Book book1 = new Book(1, "web开发", "孙卫琴", 10.05, 100, 100);
//		 Book book2 = new Book(3, "java开发", "张卫", 20.01, 100, 100);
//		 Book book4 = new Book(3, "java开发", "张卫", 20.01, 100, 100);
//		 Book book5 = new Book(3, "java开发", "张卫", 20.01, 100, 100);
//		 Book book6 = new Book(3, "java开发", "张卫", 20.01, 100, 100);
//		 Book book7 = new Book(3, "java开发", "张卫", 20.01, 100, 100);
//		 Book book8 = new Book(3, "java开发", "张卫", 20.01, 100, 100);
		 Book book3 = new Book(2, "java开发", "张卫", 20.05, 100, 100);
		 
		 Cart cart = new Cart();
		 cart.addBook2Cart(book);
//		 cart.addBook2Cart(book1);
//		 cart.addBook2Cart(book2);
//		 cart.addBook2Cart(book4);
//		 cart.addBook2Cart(book5);
//		 cart.addBook2Cart(book6);
//		 cart.addBook2Cart(book7);
//		 cart.addBook2Cart(book8);
		 cart.addBook2Cart(book3);
		 
		 CartItem cartItem = cart.getMap().get("2");
		 
		 System.out.println("购物车项单品种的总数量："+cartItem.getCount());
		 System.out.println("购物车项单品种的总金额："+cartItem.getAmount());
		 
		 System.out.println("购物车中的总数量："+cart.getTotalCount());
		 System.out.println("购物车中的总金额："+cart.getTotalAmount());
		 
		 System.out.println("-------更改购物项数量-------");
		 cart.changeCount("2", 10);
		 cartItem = cart.getMap().get("2");
		 
		 System.out.println("购物车项单品种的总数量："+cartItem.getCount());
		 System.out.println("购物车项单品种的总金额："+cartItem.getAmount());
		 
		 System.out.println("购物车中的总数量："+cart.getTotalCount());
		 System.out.println("购物车中的总金额："+cart.getTotalAmount());
		 
		 System.out.println("-------删除购物项-------");
		 cart.deleteCartItem("3");
		 
		 System.out.println("购物车中的总数量："+cart.getTotalCount());
		 System.out.println("购物车中的总金额："+cart.getTotalAmount());
		 
		 System.out.println("----------清空购物车---------");
		 cart.clear();
		 System.out.println("购物车中的总数量："+cart.getTotalCount());
		 System.out.println("购物车中的总金额："+cart.getTotalAmount());
		 
	}
	
	@Test
	public void testdouble(){
		// 通过在处理精度问题，我们使用BigDecimal
		BigDecimal d1 = new BigDecimal("10.01");
		BigDecimal d2 = new BigDecimal("10.05");
		
		//通过这种方式，对数据的操作转换成对方法的调用
		BigDecimal d3 = d1.add(d2);
		System.out.println(10.01+10.05);//20.060000000000002
		System.out.println(d3.doubleValue());//20.06
	}

}
