package com.kudangtang.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kudangtang.rest.command.MenuCommand;
import com.kudangtang.rest.domain.Menu;
import com.kudangtang.rest.service.MenuServiceImpl;

/**
 * 
 * @author "sage"
 *
 */
@Controller
public class MenuController {
	   @Autowired
	   MenuServiceImpl menuService;
	   
	   @GetMapping("/order")
	   public String findMenuForm(MenuCommand menuCommand, Model model) {
			List<Menu> menuList = menuService.findMenu();
			model.addAttribute("menuList", menuList);
			return "order";
	   }
	   
	   @PostMapping("/order")
	   public String findMenu(HttpServletRequest req,MenuCommand menuCommand, Model model) {
		  HttpSession session = req.getSession();
	      Menu menu = (Menu)session.getAttribute("guest");
	      menu.getName();
	      menu.getCategorie();
	      menu.getPrice();
	      
	      menuService.findMenu();
	      session.setAttribute("guest", menu);
	      return "order";
	   }
}
