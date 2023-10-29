package com.kudangtang.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kudangtang.rest.domain.Sale;

import lombok.ToString;

@Component
@ToString
public class SaleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SaleDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public SaleDao() {

    }

    public void addSale(Sale sale) {
        String sql = "INSERT INTO Sale (menuId, onum, quantity, salePrice) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, sale.getMenuId(), sale.getOnum(), sale.getQuantity(), sale.getSalePrice());
        System.out.println(sale.getMenuId());
    }
    
    public void save(Sale sale) {
        addSale(sale);
    }
    
    public List<Sale> findSale() {
    	String sql = "SELECT * FROM Sale";
    	List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
    	List<Sale> sales = new ArrayList<Sale>();
    	for(Map<String, Object> row : rows) {
    		Sale sale = new Sale();
    		sale.setSid((Long)row.get("sid"));
    		sale.setOnum((String)row.get("onum"));
    		sale.setMenuId((String)row.get("menuId"));
    		sale.setQuantity((int)row.get("quantity"));
    		sale.setSalePrice((long)row.get("salePrice"));
    		sale.setOrderDate((Date)row.get("orderDate"));
    		sales.add(sale);
    	}
    	return sales;
    }
    
    public List<Sale> getSalesByPeriod(String startDate, String endDate) {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT * FROM Sale WHERE orderDate BETWEEN ? AND ?";
        try {
            sales = jdbcTemplate.query(sql, pstmt -> {
                        pstmt.setString(1, startDate);
                        pstmt.setString(2, endDate);
                    },
                    (rs, rowNum) -> {
                        Sale sale = new Sale();
                        sale.setSid(rs.getLong("sid"));
                        sale.setMenuId(rs.getString("menuId"));
                        sale.setOnum(rs.getString("onum"));
                        sale.setQuantity(rs.getInt("quantity"));
                        sale.setSalePrice(rs.getLong("salePrice"));
                        sale.setOrderDate(rs.getTimestamp("orderDate"));
                        return sale;
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sales;
    }
    
    public List<Sale> findByOnum(String onum) {
        String sql = "SELECT * FROM Sale WHERE onum = ?";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, onum);
        List<Sale> sales = new ArrayList<>();
        for(Map<String, Object> row : rows) {
            Sale sale = new Sale();
            sale.setSid((Long)row.get("sid"));
            sale.setOnum((String)row.get("onum"));
            sale.setMenuId((String)row.get("menuId"));
            sale.setQuantity((int)row.get("quantity"));
            sale.setSalePrice((long)row.get("salePrice"));
            sale.setOrderDate((Date)row.get("orderDate"));
            sales.add(sale);
        }
        return sales;
    }
}
	

