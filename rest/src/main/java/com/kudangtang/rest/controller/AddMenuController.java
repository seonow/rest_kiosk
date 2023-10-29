package com.kudangtang.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kudangtang.rest.command.MenuCommand;
import com.kudangtang.rest.domain.Menu;
import com.kudangtang.rest.service.MenuService;
import com.kudangtang.rest.service.MenuServiceImpl;



@Controller
public class AddMenuController {
   @Autowired
   MenuService menuservice;

   @Autowired
   MenuServiceImpl menuService;
   
   @GetMapping("/rest/addmenu")
   public String adminForm(MenuCommand menucommand, Model model) {
      return "rest/add_menu";
   }
   
   @PostMapping("/rest/addmenu")
   public String addMenu(MenuCommand menucommand, Model model) {
      Menu menu = new Menu();
      menu.setName(menucommand.getName());
      menu.setCategorie(menucommand.getCategorie());
      menu.setPrice(menucommand.getPrice());
      menuservice.addMenu(menu);
      
      List<Menu> menuList = menuService.findMenu();
      model.addAttribute("menuList", menuList);
      return "rest/menulist";
   }
   


}
