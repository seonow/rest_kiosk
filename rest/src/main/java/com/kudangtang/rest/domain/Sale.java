package com.kudangtang.rest.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Sale {
	private long sid;
	private String menuId;
	
	private Menu menu;
	private String onum;
	private int quantity;
	private long salePrice;
	private Date orderDate;
	
	private boolean isFirstItemInGroup;
	
	public Sale(String menuId, long salePrice, int quantity) {
		super();
		this.menuId = menuId;
		this.quantity = quantity;
		this.salePrice = salePrice;
	}

	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale(String menuId, String onum, int quantity, long salePrice) {
		super();
		this.menuId = menuId;
		this.onum = onum;
		this.quantity = quantity;
		this.salePrice = salePrice;
	}

	public Sale(long sid, int quantity, long salePrice) {
		super();
		this.sid = sid;
		this.quantity = quantity;
		this.salePrice = salePrice;
	}



	

	
	
	
	
}
