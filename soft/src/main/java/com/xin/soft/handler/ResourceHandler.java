package com.xin.soft.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class ResourceHandler extends Handler {

	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {		
		
		if (target.lastIndexOf(".jsp") != -1||target.lastIndexOf(".png") != -1) {
			try {
				String contextPath=request.getContextPath();
				response.sendRedirect(contextPath+"/resource");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			nextHandler.handle(target, request, response, isHandled);
		}

	}

}
