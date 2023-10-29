package com.kudangtang.rest.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kudangtang.rest.command.SaleCommand;
import com.kudangtang.rest.domain.LineItem;
import com.kudangtang.rest.domain.Menu;
import com.kudangtang.rest.domain.Sale;
import com.kudangtang.rest.service.SaleServiceImpl;

@Controller
public class SaleController {
	@Autowired
	SaleServiceImpl saleservice;

	@GetMapping("/rest/salelist")
	public String findSaleForm(SaleCommand salecommand, Model model) {
		List<Sale> saleList = saleservice.findSale();
		
		
		model.addAttribute("saleList", saleList);
		return "rest/salelist";
	}
	
//	@GetMapping("/rest/salelist")
//	public String findSaleForm(SaleCommand salecommand, Model model,
//	        @RequestParam(required = false) String onum) {
//	    List<Sale> saleList;
//	    if (onum == null) {
//	        saleList = saleservice.findSale();
//	    } else {
//	        saleList = saleservice.findByOnum(onum);
//	    }
//
//	    List<List<Sale>> groupedSales = groupSalesByOnum(saleList);
//	    model.addAttribute("groupedSales", groupedSales);
//	    return "rest/salelist";
//	}


	@PostMapping("/rest/salelist")
	public String findSale(SaleCommand salecommand, Model model) {
		Sale sale = new Sale();
		sale.getOnum();
		sale.getMenu().getName();
//		sale.getMenuId();
		sale.getQuantity();
		sale.getSalePrice();
		sale.getOrderDate();

		return "rest/salelist";
	}
	private List<List<Sale>> groupSalesByOnum(List<Sale> saleList) {
	    List<List<Sale>> groupedSales = new ArrayList<>();

	    Sale prevSale = null;
	    List<Sale> curGroup = null;

	    for (Sale sale : saleList) {
	        if (prevSale == null || sale.getOnum() != prevSale.getOnum()) {
	            // Start a new group
	            curGroup = new ArrayList<>();
	            groupedSales.add(curGroup);
	        }

	        // Set the 'isFirstItemInGroup' property
	        boolean isFirstItemInGroup = curGroup.isEmpty();
	        sale.setFirstItemInGroup(isFirstItemInGroup);

	        curGroup.add(sale);
	        prevSale = sale;
	    }

	    return groupedSales;
	}
	
	@GetMapping("/rest/salesinquiry")
	public String getSalesByPeriod(Model model,
	                               @RequestParam(required = false) String startDate,
	                               @RequestParam(required = false) String endDate) {
	    if (startDate == null || endDate == null) {
	        LocalDate now = LocalDate.now();
	        startDate = now.withDayOfMonth(1).toString();
	        endDate = now.toString();
	    }
	    model.addAttribute("startDate", startDate);
	    model.addAttribute("endDate", endDate);
	    List<Sale> sales = saleservice.getSalesByPeriod(startDate, endDate);
	    model.addAttribute("sales", sales);
	    return "rest/salesinquiry";
	}
}