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
public class DeleteMenuController {
    @Autowired
    MenuServiceImpl menuService;

    // GET 요청 처리 메서드
    @GetMapping("/rest/deletemenu")
    public String menuDeleteForm(MenuCommand menuCommand, Model model) {
		List<Menu> menuList = menuService.findMenu();
		model.addAttribute("menuList", menuList);

        return "rest/delete_menu";
    }
    
  

    // POST 요청 처리 메서드
    @PostMapping("/rest/deletemenu")
    public String menuDelete(MenuCommand menuCommand, Model model) {
        Menu menu = new Menu();
        menu.setName(menuCommand.getName());
        menuService.deleteMenu(menu);
        menu.getName();
        menu.getCategorie();
        menu.getPrice();

        List<Menu> menuList = menuService.findMenu();
        model.addAttribute("menuList", menuList);
        menuService.findMenu();
        
        return "rest/menulist";
    }
}