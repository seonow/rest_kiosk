package com.kudangtang.rest.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuCommand {
	private String name;
	private String categorie;
	private long price;
	
	MenuCommand(){
		
	}
}
