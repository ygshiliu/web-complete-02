package com.atguigu.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HelloHttpSessionListener
 *
 */
public class HelloHttpSessionListener implements HttpSessionListener {

    public HelloHttpSessionListener() {
      System.out.println("session构造器");
    }

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//System.out.println("sessionInit 创建 ");
		
		HttpSession session = se.getSession();
		String id = session.getId();
		//System.out.println(id);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//System.out.println("sessiondestroy 销毁 ");
	}
    
    
	
}
