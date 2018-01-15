package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.imp.UserDaoImpl;

/**
 * 文件名: UserDaoTest.java
 * 描述: 测试UserDao方法
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月10日 下午3:29:20
 */
public class UserDaoTest {
	private UserDao ud = new UserDaoImpl();
	
	@Test
	public void testSaveUser() {
		User user = new User(null, "刘在石", "123123", "liuzaishi@163.com");
		int i = ud.saveUser(user);
		System.out.println(i);
	}

	@Test
	public void testGetUserByUsernameAndPassword() {
		User user = new User(null, "刘在石", "123123", null);
		user = ud.getUserByUsernameAndPassword(user);
		System.out.println(user);
	}

}
