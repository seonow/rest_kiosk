package com.kudangtang.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kudangtang.rest.domain.Menu;

import lombok.ToString;

@Component
@ToString
@Configuration
public class MenuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MenuDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public MenuDao() {

	}

	public void addMenu(Menu menu) {
		String sql = "INSERT INTO Menu (mname, mct, mprice) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, menu.getName(), menu.getCategorie(), menu.getPrice());
	}

	public List<Menu> findMenu() {
		String sql = "SELECT * FROM Menu";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<Menu> menus = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			Menu menu = new Menu();
			menu.setCategorie((String) row.get("mct"));
			menu.setName((String) row.get("mname"));
			menu.setPrice((long) row.get("mprice"));
			menus.add(menu);
		}
		return menus;
	}

	public void menuUpdate(Menu menu) {
		String sql = "UPDATE Menu SET mprice = ? WHERE mname = ?";
		jdbcTemplate.update(sql, menu.getPrice(), menu.getName());

	}

	public void deleteMenu(Menu menu) {
		String sql = "DELETE from Menu WHERE mname = ?";
		jdbcTemplate.update(sql, menu.getName());

	}

	public Menu findByName(String name) {
		String sql = "SELECT * FROM Menu WHERE mname = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new MenuRowMapper(), name);
		} catch (DataAccessException e) {
			return null;
		}
	}

}
