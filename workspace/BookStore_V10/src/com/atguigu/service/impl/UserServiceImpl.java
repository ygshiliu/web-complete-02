package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.imp.UserDaoImpl;
import com.atguigu.service.UserService;


/**
 * 文件名: UserService.java
 * 描述: UserService实现类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月10日 下午3:53:27
 */
public class UserServiceImpl implements UserService {
	
	private UserDao ud = new UserDaoImpl();

	@Override
	public boolean regist(User user) {
		int count = ud.saveUser(user);
		return count > 0;
		
	}

	@Override
	public User login(User user) {
		return ud.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean checkUsername(String username) {
		User user = ud.getUserByUsername(username);
		return user==null;
		
	}

}
