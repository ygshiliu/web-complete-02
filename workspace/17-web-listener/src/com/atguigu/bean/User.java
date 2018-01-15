package com.atguigu.bean;

import java.io.Serializable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class User
 *
 */
public class User implements HttpSessionActivationListener,HttpSessionBindingListener,Serializable {
	
	private String name;
	private String password;
	
    public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
     * Default constructor. 
     */
    public User() {
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

	/**
	 * 设置进session对象时调用
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("user对象移除session域");
    	
    	String name = event.getName();
    	Object value = event.getValue();
    	System.out.println(name+"--"+value);
    	
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("user对象设置进session域中");
    	
    	String name = event.getName();
    	Object value = event.getValue();
    	System.out.println(name+"--"+value);
    	
    }

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("user对象同session一起钝化到硬盘");
		HttpSession session = se.getSession();
		System.out.println(session.getId());
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("user对象同session一起活化到内存");
	}
	
}
