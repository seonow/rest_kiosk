package com.kudangtang.rest.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	private List<LineItem> lineItemList;
	private LineItem lineItem;
	
	public Cart() {
		lineItemList = new ArrayList<>();
	}
	
	public void addLineItem(LineItem lineItem) {
        boolean isNewItem = true;
        for (LineItem item : lineItemList) {
            if (item.getMenu().getName().equals(lineItem.getMenu().getName())) {
                item.setQuantity(item.getQuantity() + lineItem.getQuantity());
                item.setSalePrice(item.getSalePrice() + lineItem.getSalePrice());
                isNewItem = false;
                break;
            }
        }
        if (isNewItem) {
		lineItemList.add(lineItem);
        }
	}
	
	public String toString() {
		StringBuilder sb = new  StringBuilder();
		for(LineItem item : lineItemList) {
			sb.append(item.getMenu().getName() + " : " + item.getQuantity() + " 가격 : " + item.getMenu().getPrice() * item.getQuantity() );
		}
		return sb.toString();
	}



	public LineItem getLineItem(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}
	
//    public void addMenuItem(LineItem lineItem) {
//        boolean isNewItem = true;
//        for (LineItem item : lineItemList) {
//            if (item.getMenu().getName().equals(lineItem.getMenu().getName())) {
//                item.setQuantity(item.getQuantity() + lineItem.getQuantity());
//                isNewItem = false;
//                break;
//            }
//        }
//        if (isNewItem) {
//            lineItemList.add(lineItem);
//        }
//    }
}

