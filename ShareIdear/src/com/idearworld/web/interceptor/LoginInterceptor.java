package com.idearworld.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Object obj=invocation.getInvocationContext().getSession().get("loginUser");
		
		if(obj==null){
			return "loginPage";
		}
		
		return invocation.invoke();
	}

}
