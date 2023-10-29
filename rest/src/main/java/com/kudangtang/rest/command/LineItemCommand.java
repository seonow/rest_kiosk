package com.kudangtang.rest.command;

import com.kudangtang.rest.domain.Menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LineItemCommand {
	private Menu menu;		//메뉴
	private int quantity;	//수량
	private double salePrice; //최종판매가격

	public LineItemCommand() {
		
	}
}
