package com.kudangtang.rest.command;

import com.kudangtang.rest.domain.Cart;
import com.kudangtang.rest.domain.LineItem;
import com.kudangtang.rest.domain.Menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleCommand {
   private Cart cart;
   private String menuId;
   private Menu menu;
   private LineItem lineitem;
   private int quantity;
   private long salePrice;
   
   public SaleCommand() {
      
   }
}