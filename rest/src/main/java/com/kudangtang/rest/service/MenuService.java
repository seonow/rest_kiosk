package com.kudangtang.rest.service;

import java.util.List;

import com.kudangtang.rest.domain.Menu;

public interface MenuService {

	public void addMenu(Menu menu);

	public List<Menu> findMenu();

	public void menuUpdate(Menu menu);

	public void deleteMenu(Menu menu);

	public Menu findByName(String name);
}
