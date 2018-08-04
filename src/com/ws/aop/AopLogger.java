package com.ws.aop;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import com.ws.entity.SystemContext;
import com.ws.entity.User;


public class AopLogger {
	
	
	private Logger log = Logger.getLogger(AopLogger.class);
	
	
	public void after(JoinPoint joinPoint){  
//		
		String name = joinPoint.getSignature().getName(); 
		HttpSession session = SystemContext.getReq().getSession();
		User user = null;
		try {
			user = (User) session.getAttribute("loginUser");
			log.warn(user.getUsername()+ "-执行-"+ name + "-成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		
		
	}  
	 
	/*public void before(){  
			log.warn("login start!");  
	}  */
}
