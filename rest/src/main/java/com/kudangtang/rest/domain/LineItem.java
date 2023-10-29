package com.kudangtang.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LineItem {
	public LineItem() {
	
	}
	private Menu menu;		//메뉴
	private int quantity;	//수량
	private long salePrice; //최종판매가격
	
}
