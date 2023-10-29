package com.kudangtang.rest.dao;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kudangtang.rest.domain.Admin;

@SpringBootTest
public class AdminDaoTest {
	@Autowired
	private AdminDao dao;
	
	@Test
	public void findAdmin() {
		Admin admin = dao.findAdmin("admin");
		System.out.println(admin);
	}
	
	
}
