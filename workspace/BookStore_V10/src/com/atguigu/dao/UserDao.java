package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * 文件名: UserDao.java
 * 描述: 与用户相关的操作
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月10日 下午3:06:11
 */
public interface UserDao {
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	/**
	 * 根据用户名和密码获取用户信息
	 * @param user
	 * @return
	 */
	User getUserByUsernameAndPassword(User user);
	/**
	 * 根据用户名获取用户，主要用于检查用户是否存在
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
}
