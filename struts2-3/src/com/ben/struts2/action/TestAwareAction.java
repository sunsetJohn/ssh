package com.ben.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TestAwareAction implements ApplicationAware,SessionAware,RequestAware,ParameterAware {

	public String execute()
	{
		
		//1. ��application �м���һ�����ԣ� applicationKey2 - applicationValue2
		application.put("applicationKey2", "applicationValue2");
		
		//2. ��application �ж�ȡһ������date ����ӡ
		System.out.println(application.get("date"));
		
		return "success";
	}

	private Map<String, Object> application;
	
	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.application = arg0;
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}