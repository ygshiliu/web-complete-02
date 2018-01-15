package junit;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * 文件名: UserServiceTest.java
 * 描述: UserService方法测试
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月10日 下午3:57:38
 */
public class UserServiceTest {
	
	private UserService us = new UserServiceImpl();

	@Test
	public void testRegist() {
		User user= new User(null, "宋智孝", "123123", "songzhixiao@163.com");
		boolean flag = us.regist(user);
		System.out.println(flag);
	}

	@Test
	public void testLogin() {
		User user= new User(null, "宋智孝", "123123", null);
		User login = us.login(user);
		System.out.println(login);
	}

}
