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
public class UpdateMenuController {
   @Autowired
   MenuServiceImpl menuService;

   @GetMapping("/rest/updatemenu")
   public String updateMenuform(MenuCommand menuCommand, Model model) {
      return "rest/update_menu";
   }
   
   @PostMapping("/rest/updatemenu")
   public String updateMenu(MenuCommand menucommand, Model model) {
      Menu menu = new Menu();
      menu.setPrice(menucommand.getPrice());
      menu.setName(menucommand.getName());
      menuService.menuUpdate(menu);

      List<Menu> menuList = menuService.findMenu();
      model.addAttribute("menuList", menuList);
      return "rest/menulist";
   }
}
