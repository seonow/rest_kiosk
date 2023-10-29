package com.kudangtang.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kudangtang.rest.dao.AdminDao;
import com.kudangtang.rest.domain.Admin;

@Component
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin findAdmin(String id) {
		return adminDao.findAdmin(id);
	}

}
