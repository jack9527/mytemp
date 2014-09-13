package com.xin.soft.service;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

@Service
public class AdminService {
	public int newAdmin(){
		int cols=0;
		Record admin=new Record();
		admin.set("admin_id", 2222);
		admin.set("password", "2222");
		admin.set("real_name", "real1_name");
		Db.save("admin", admin);
		return cols;
	}
}
