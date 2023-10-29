package com.kudangtang.rest.service;

import java.util.List;

import com.kudangtang.rest.domain.Sale;

public interface SaleService {
	public void addSale(Sale sale);
	
	public void save(Sale sale);
	
	public List<Sale> findSale();
	
	public List<Sale> getSalesByPeriod(String startDate, String endDate);
	
	public List<Sale> findByOnum(String onum);
}
