package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

/**
 * 文件名: TestPage.java
 * 描述: 测试page类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月14日 下午4:11:09
 */
public class TestPage {
	
	
	@Test
	public void test() {
		
		Page<Book> page = new Page<Book>();
		
		page.setPageNo(1);
		page.setPageSize(2);
		page.setTotalCount(10);
		
		System.out.println("索引："+page.getIndex());
		System.out.println("总页数："+page.getTotalPage());
		
	}

}
