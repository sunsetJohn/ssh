package com.ben.struts2.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware,ApplicationAware{
	
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String logout()
	{
		Integer count = (Integer) application.get("count");
		if(count != null && count > 0)
		{
			count--;
			application.put("count", count);
		}
		((SessionMap)session).invalidate();
		
		return "logout-success";
	}
	
	public String execute()
	{
		//把用户信息存入Session 域中
		//1. 获取session 通过实现SessionAware 接口
		
		//2. 获取登陆信息
		
		//3. 存入
		session.put("username", username);
		
		//在线人数加1
		//1. 获取当前的在线人数（ application）
		Integer count = (Integer) application.get("count");
		if(count == null)
		{
			count = 0;
		}
		
		//2. +1
		count++;
		
		application.put("count", count);
		
		return "login-success";
	}
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.application = arg0;
	}

}
