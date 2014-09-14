package com.xin.soft.controll;

import com.jfinal.core.Controller;

public class ResourceController extends Controller {
	public void index(){
		String http="http://www.hao123.com";
		redirect(http);
	}
}