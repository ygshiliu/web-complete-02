package com.atguigu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Application Lifecycle Listener implementation class appAttrListener
 *
 */
public class appAttrListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public appAttrListener() {
       System.out.println("appAttrListener 构造器");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scab)  { 
    	String name = scab.getName();
    	Object value = scab.getValue();
        System.out.println("attributeAdded"+"--name:"+name+"--value:"+value);
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scab)  { 
    	System.out.println("attributeReplaced");
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scab)  { 
    	System.out.println("attributeRemoved");
         // TODO Auto-generated method stub
    }
	
}
