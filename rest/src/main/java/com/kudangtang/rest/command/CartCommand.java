package com.kudangtang.rest.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartCommand {
	private LineItemCommand lineItem;
	private MenuCommand menu;
	
	public CartCommand() {
		
	}
}
