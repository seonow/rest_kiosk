package com.kudangtang.rest.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kudangtang.rest.domain.Menu;

public class MenuRowMapper implements RowMapper<Menu> {

	@Override
	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menu menu = new Menu();
		
		menu.setName(rs.getString("mname"));
		menu.setCategorie(rs.getString("mct"));
		menu.setPrice(rs.getLong("mprice"));
	
		
		return menu;
	}
	
	
}
