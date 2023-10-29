package com.kudangtang.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kudangtang.rest.domain.Admin;
import com.kudangtang.rest.rowmapper.AdminRowMapper;

@Component
public class AdminDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Admin findAdmin(String id) {
		String sql = "SELECT * FROM Admin WHERE id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new AdminRowMapper(), id);
		}catch(DataAccessException e) {
			return null;
		}
	}
}
