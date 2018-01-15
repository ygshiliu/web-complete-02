package com.atguigu.dao.imp;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;

/**
 * 文件名: UserDaoImpl.java
 * 描述: userDao实现 类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月10日 下午3:14:39
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public int saveUser(User user) {
		String sql = "insert into bs_users(username,password,email) values (?,?,?)";
		return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
		
	}

	@Override
	public User getUserByUsernameAndPassword(User user) {
		String sql = "select id,username,password,email from bs_users where username=? and password =?";
		return getBean(sql, user.getUsername(),user.getPassword());
		
	}



}
