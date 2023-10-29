package com.kudangtang.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Menu {
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private String categorie;
	private long price;
	
}
