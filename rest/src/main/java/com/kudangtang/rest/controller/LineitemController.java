package com.kudangtang.rest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kudangtang.rest.command.LineItemCommand;
import com.kudangtang.rest.domain.Cart;
import com.kudangtang.rest.domain.LineItem;
import com.kudangtang.rest.domain.Menu;
import com.kudangtang.rest.service.MenuServiceImpl;

@Controller
public class LineitemController {

	@Autowired
	private MenuServiceImpl menuService;

	@GetMapping("/cart")
	public String viewCart(HttpSession session, Model model) {
		Cart cart = getCart(session);
		model.addAttribute("cart", cart);
		return "cart/checkout";
	}

	@PostMapping("/menu/cart")
	public String addToCart(@RequestParam("mname") String mname, @RequestParam("quantity") int quantity,
			HttpSession session, Model model) {
		Menu menu = menuService.findByName(mname);
		LineItem lineItem = null;
		Cart cart = null;
		if (menu != null) {
			lineItem = new LineItem(menu, quantity, menu.getPrice() * quantity);
			cart = addToCart(lineItem, session);
		}
		model.addAttribute("cart", cart);
		
		List<Menu> menuList = menuService.findMenu();
		model.addAttribute("menuList", menuList);
		return "order";
	}

//	@PostMapping("/cart/checkout")
//	public String updateCartList(LineItemCommand[] lineItems, HttpSession session, Model model) {
//		Cart cart = getCart(session);
//		for (LineItemCommand lineItemCommand : lineItems) {
//			for (LineItem lineItem : cart.getLineItemList()) {
//				if (lineItem.getMenu().getName().equals(lineItemCommand.getMenu())) {
//					lineItem.setQuantity(lineItemCommand.getQuantity());
//					lineItem.setSalePrice(lineItem.getMenu().getPrice() * lineItem.getQuantity());
//					break;
//				}
//			}
//		}
//		session.setAttribute("cart", cart);
//	    model.addAttribute("cart", cart); // 모델에 "cart" 객체를 추가
//		return "rest/sale";
//	}

	@PostMapping("/menu/cart/updateQuantity")
	public String updateQuantity(@RequestParam("mname") String mname, @RequestParam("quantity") int quantity,
	        HttpSession session, Model model) {
	    Cart cart = (Cart) session.getAttribute("cart");
	    if (cart != null) {
	        for (LineItem item : cart.getLineItemList()) {
	            if (item.getMenu().getName().equals(mname)) {
	                item.setQuantity(quantity);
	                item.setSalePrice(item.getMenu().getPrice() * quantity);
	                break;
	            }
	        }
	    }
	    model.addAttribute("cart", cart);
	    List<Menu> menuList = menuService.findMenu();
	    model.addAttribute("menuList", menuList);
	    return "order";
	}

	
	@PostMapping("/cart/remove")
	public String removeFromCart(@RequestParam("mname") String mname, HttpSession session) {
		Cart cart = getCart(session);
		Menu menu = menuService.findByName(mname);
		if (menu != null) {
			for (LineItem lineItem : cart.getLineItemList()) {
				if (lineItem.getMenu().equals(menu)) {
					//cart.remove(lineItem);
					break;
				}
			}
		}
		session.setAttribute("cart", cart);
		return "include/cart";
	}

	private Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}

	private Cart addToCart(LineItem lineItem, HttpSession session) {
		Cart cart = getCart(session);
		boolean found = false;
		for (LineItem item : cart.getLineItemList()) {
			if (item.getMenu().equals(lineItem.getMenu())) {
				item.setQuantity(item.getQuantity() + lineItem.getQuantity());
				item.setSalePrice(item.getMenu().getPrice() * item.getQuantity());
				found = true;
				break;
			}
		}
		if (!found) {
			cart.addLineItem(lineItem);
		}
		session.setAttribute("cart", cart);
		return cart;
	}
	private void updateCart(Cart cart, HttpSession session) {
	    session.setAttribute("cart", cart);
	}

}
