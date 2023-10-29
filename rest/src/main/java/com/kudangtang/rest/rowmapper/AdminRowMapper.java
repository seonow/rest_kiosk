package com.kudangtang.rest.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.kudangtang.rest.domain.Admin;


public class AdminRowMapper implements RowMapper<Admin>{
	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getString("id"));
		admin.setPw(rs.getString("pw"));
		return admin;
	}
}
