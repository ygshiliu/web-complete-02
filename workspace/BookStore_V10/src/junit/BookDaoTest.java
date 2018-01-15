package junit;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.imp.BookDaoImpl;

/**
 * 文件名: BookDaoTest.java 描述: 测试BookDao方法 开发人员： Miss Wang 创建时间： 2017年3月14日
 * 上午10:43:48
 */
public class BookDaoTest {

	private BookDao bd = new BookDaoImpl();

	@Test
	public void testSaveBook() {
		Book book = new Book(null, "Tomcat与JavaWeb开发", "孙卫琴", 79.5, 100, 100);
		bd.saveBook(book);
	}

	@Test
	public void testUpdateBook() {
		Book book = new Book(1, "Tomcat与JavaWeb开发1", "孙卫琴1", 80, 50, 80);
		int i = bd.updateBook(book);
		System.out.println(i);
	}

	@Test
	public void testDeleteBook() {
		int count = bd.deleteBook("1");
		System.out.println(count);
	}

	@Test
	public void testGetBook() {
		Book book = bd.getBook("1");
		System.out.println(book);
	}

	@Test
	public void testGetAll() {
		List<Book> list = bd.getAll();
		System.out.println(list);
	}

	@Test
	public void testfindBook() {
		Page<Book> page = new Page<Book>();
		page.setPageNo(1);
		page.setPageSize(2);
		
		page= bd.findBook(page);
		
		System.out.println(page.getList());
	}
	@Test
	public void testUpdateStockAndSale(){
		int count = bd.updateStockAndSale(100, 100, 12);
		System.out.println(count);
	}
}
