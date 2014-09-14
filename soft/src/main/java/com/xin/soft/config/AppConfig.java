package com.xin.soft.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.spring.SpringPlugin;
import com.xin.soft.controll.AdminController;
import com.xin.soft.controll.DemoController;
import com.xin.soft.controll.ResourceController;
import com.xin.soft.controll.RootController;
import com.xin.soft.handler.ResourceHandler;
import com.xin.soft.interceptor.GlobalInterceptor;

/**
 * API引导式配置
 */
public class AppConfig extends JFinalConfig {

	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用getProperty(...)获取值
		loadPropertyFile("a_little_config.txt");
		me.setDevMode(getPropertyToBoolean("devMode", false));
	}

	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		
		  me.add("/", RootController.class); 
		  me.add("/admin", AdminController.class);
		  me.add("/demo",DemoController.class);
		  
		  //静态资源处理
		  me.add("/resource",ResourceController.class);
		 
	}

	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
				getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		// arp.addMapping("blog", Blog.class); // 映射blog 表到 Blog模型
		
		//配置spirng plugin
		SpringPlugin sp=new SpringPlugin();
		me.add(sp);
	}

	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		me.add(new GlobalInterceptor());
	}

	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		//me.add(new ResourceHandler());
	}
}
