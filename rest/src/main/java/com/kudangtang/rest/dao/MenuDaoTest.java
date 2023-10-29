package com.kudangtang.rest.dao;


import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.kudangtang.rest.domain.Menu;

public class MenuDaoTest {
	public static void main(String[] args) {
		addMenu();
//		findMenu();
//		menuUpdate();
//		deleteMenu();
	}
	
	public static void addMenu() {
        // 데이터베이스 정보 설정
        String url = "jdbc:mysql://localhost:3306/rest";
        String username = "rest";
        String password = "rest";

        // DriverManagerDataSource 객체 생성
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);

        // MenuDao 객체 생성 시 DriverManagerDataSource 객체를 인자로 전달
        MenuDao dao = new MenuDao(dataSource);

        Menu menu = new Menu();
        menu.setName("짬뽕");
        menu.setCategorie("중식");
        menu.setPrice(4000);

        dao.addMenu(menu);
	}
	
	public static List<Menu> findMenu() {
	    // 데이터베이스 정보 설정
	    String url = "jdbc:mysql://localhost:3306/rest";
	    String username = "rest";
	    String password = "rest";

	    // DriverManagerDataSource 객체 생성
	    DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);

	    // MenuDao 객체 생성 시 DriverManagerDataSource 객체를 인자로 전달
	    MenuDao dao = new MenuDao(dataSource);
	   
	    // 데이터베이스에서 모든 메뉴 정보 조회
	    List<Menu> menuList = dao.findMenu();

	    // 조회된 메뉴 정보 출력
	    for (Menu menu : menuList) {
	        System.out.println(menu);
	    }

	    return menuList;
	}
	
	public static void menuUpdate() {
	     // 데이터베이스 정보 설정
        String url = "jdbc:mysql://localhost:3306/rest";
        String username = "rest";
        String password = "rest";

        // DriverManagerDataSource 객체 생성
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);

        // MenuDao 객체 생성 시 DriverManagerDataSource 객체를 인자로 전달
        MenuDao dao = new MenuDao(dataSource);
        Menu menu = new Menu();
        menu.setName("짜장면");
        menu.setPrice(5000);
        dao.menuUpdate(menu);
        
	}
	
	public static void deleteMenu() {
	    // 데이터베이스 정보 설정
        String url = "jdbc:mysql://localhost:3306/rest";
        String username = "rest";
        String password = "rest";

        // DriverManagerDataSource 객체 생성
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
        
        // MenuDao 객체 생성 시 DriverManagerDataSource 객체를 인자로 전달
        MenuDao dao = new MenuDao(dataSource);
        Menu menu = new Menu();
        menu.setName("만두");
        dao.deleteMenu(menu);
	}

}
