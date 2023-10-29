package com.kudangtang.rest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kudangtang.rest.domain.Cart;
import com.kudangtang.rest.domain.LineItem;
import com.kudangtang.rest.domain.Menu;
import com.kudangtang.rest.domain.Sale;
import com.kudangtang.rest.service.SaleServiceImpl;

@Controller
public class CheckoutController {

	@Autowired
	private SaleServiceImpl saleService;

	@GetMapping("/cart/checkout")
	public String viewCheckout(HttpSession session, Model model) {
		Cart sale = getCart(session);
		model.addAttribute("sale", sale);
		model.addAttribute("totalPrice", getTotalPrice(sale));
		return "rest/sale";
	}

	@PostMapping("/sale/success")
	public String completeCheckout(HttpSession session, Model model) {
		Cart cart = (Cart) session.getAttribute("cart");
		for (LineItem lineItem : cart.getLineItemList()) {
			Menu menu = lineItem.getMenu();
			System.out.println("menu=" + menu);
			saleService.save(new Sale(lineItem.getMenu().getName(),session.getId().substring(0, 20), lineItem.getQuantity(),
					lineItem.getSalePrice()));
				
			session.removeAttribute("cart");
			
		}
		
		List<LineItem> lineItems = cart.getLineItemList(); // Save line items to a separate variable
		session.invalidate(); // Invalidate the session
		model.addAttribute("lineItems", lineItems);
		model.addAttribute("sales", session.getId().substring(0, 20));
		
		return "rest/sale_success";
		
	}

	private Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		return cart;
	}

	private double getTotalPrice(Cart cart) {
		double totalPrice = 0.0;
		for (LineItem lineItem : cart.getLineItemList()) {
			totalPrice += lineItem.getSalePrice() * lineItem.getQuantity();
		}
		return totalPrice;
	}
}
