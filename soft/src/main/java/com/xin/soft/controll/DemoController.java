package com.xin.soft.controll;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.spring.IocInterceptor;

@Before(IocInterceptor.class)
public class DemoController extends Controller {
	
	public void editor(){
		render("/demo/editor.html");
	}
}
