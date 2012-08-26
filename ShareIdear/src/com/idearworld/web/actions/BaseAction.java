package com.idearworld.web.actions;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.idearworld.beans.LoginUserBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2531247109762694775L;
	
	static final Logger logger=Logger.getLogger(BaseAction.class);
	public WebApplicationContext getWebApplicationContext() {
		return WebApplicationContextUtils.getWebApplicationContext(getServletContext(ActionContext.getContext()));
	}

	protected ServletContext getServletContext(ActionContext context) {

		return ServletActionContext.getServletContext();

	}
	
	protected Map<String, Object> getSession(){
		
	   return ActionContext.getContext().getSession();
	}
	
	protected void putToValueStack(String key,Object val){
		 ActionContext.getContext().getValueStack().getContext().put(key, val);
	}
	
	protected LoginUserBean getLoginUser(){
		Object obj=getSession().get("loginUser");
		if(obj!=null){
			LoginUserBean userBean=(LoginUserBean)obj;
			return userBean;
		}else{
			logger.warn("user have not login......");
		}
		
		return null;
	}
	
}
