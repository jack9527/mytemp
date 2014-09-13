package com.xin.soft.controll;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.spring.Inject;
import com.jfinal.plugin.spring.IocInterceptor;
import com.xin.soft.service.AdminService;

@Before(IocInterceptor.class)
public class AdminController extends Controller {
	
	@Inject.BY_TYPE
	private AdminService service;

	public void index() {
		service.newAdmin();
		renderJsp("/index.jsp");
	}
}
