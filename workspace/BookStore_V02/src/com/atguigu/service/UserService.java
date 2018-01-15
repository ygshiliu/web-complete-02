package com.atguigu.service;

import com.atguigu.bean.User;

/**
 * 文件名: UserService.java
 * 描述: 与用户相关的业务方法
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月10日 下午3:51:01
 */
public interface UserService {
	
	/**
	 * 注册一个用户信息
	 * @param user
	 * @return
	 */
	public boolean regist(User user);
	
	/**
	 * 根据前台提供的用户名与密码查找用户
	 * @param user
	 * @return
	 */
	public User login(User user);
}
