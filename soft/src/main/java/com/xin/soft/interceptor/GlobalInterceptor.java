package com.xin.soft.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

public class GlobalInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		Controller c = ai.getController();
		String contextPath = c.getRequest().getContextPath();
		c.setAttr("contextPath", contextPath);
		ai.invoke();
	}

}
