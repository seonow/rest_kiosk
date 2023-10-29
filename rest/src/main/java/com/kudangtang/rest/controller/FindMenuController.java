package com.kudangtang.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kudangtang.rest.command.MenuCommand;
import com.kudangtang.rest.domain.Menu;
import com.kudangtang.rest.service.MenuServiceImpl;

@Controller
public class FindMenuController {
	@Autowired
	MenuServiceImpl menuService;

	@GetMapping("/rest/menulist")
	public String findMenuForm(MenuCommand menuCommand, Model model) {
		List<Menu> menuList = menuService.findMenu();
		model.addAttribute("menuList", menuList);
		return "rest/menulist";
	}

	@PostMapping("/rest/menulist")
	public String findMenu(MenuCommand menuCommand, Model model) {
		Menu menu = new Menu();
		menu.getName();
		menu.getCategorie();
		menu.getPrice();

		List<Menu> menuList = menuService.findMenu();
		model.addAttribute("menuList", menuList);
		menuService.findMenu();
		return "rest/menulist";
	}
}