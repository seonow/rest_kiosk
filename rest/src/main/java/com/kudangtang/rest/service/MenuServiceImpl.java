package com.kudangtang.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kudangtang.rest.dao.MenuDao;
import com.kudangtang.rest.domain.Menu;

@Component
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menudao;

	@Override
	public void addMenu(Menu menu) {
		menudao.addMenu(menu);

	}

	@Override
	public List<Menu> findMenu() {
		return menudao.findMenu();
	}

	@Override
	public void menuUpdate(Menu menu) {
		menudao.menuUpdate(menu);

	}

	@Override
	public void deleteMenu(Menu menu) {
		menudao.deleteMenu(menu);

	}

	@Override
	public Menu findByName(String name) {
		return menudao.findByName(name);
	}

}
