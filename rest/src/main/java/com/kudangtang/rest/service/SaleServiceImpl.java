package com.kudangtang.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kudangtang.rest.dao.SaleDao;
import com.kudangtang.rest.domain.Sale;

@Component
public class SaleServiceImpl implements SaleService{
	@Autowired
	SaleDao saledao;

	@Override
	public void addSale(Sale sale) {
		saledao.addSale(sale);
		
	}
	
	@Override
	public void save(Sale sale) {
		saledao.save(sale);
		
	}

	@Override
	public List<Sale> findSale() {
		return saledao.findSale();
	}

	@Override
	public List<Sale> getSalesByPeriod(String startDate, String endDate) {
		return saledao.getSalesByPeriod(startDate, endDate);
	}

	@Override
	public List<Sale> findByOnum(String onum) {
		return saledao.findByOnum(onum);
	}
	
	
}
