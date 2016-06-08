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
		//���û���Ϣ����Session ����
		//1. ��ȡsession ͨ��ʵ��SessionAware �ӿ�
		
		//2. ��ȡ��½��Ϣ
		
		//3. ����
		session.put("username", username);
		
		//����������1
		//1. ��ȡ��ǰ������������ application��
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