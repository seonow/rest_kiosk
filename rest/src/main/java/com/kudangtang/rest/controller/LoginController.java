package com.kudangtang.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kudangtang.rest.domain.Admin;
import com.kudangtang.rest.service.AdminServiceImpl;


@Controller
public class LoginController {
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@GetMapping("/login")
	public String loginForm() {
		return "/rest/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest req , Model model) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		Admin admin = adminServiceImpl.findAdmin(id);
		if(admin == null) {
			return "rest/login";
		}
		if(admin.getPw().equals(pw)) {
			HttpSession session = req.getSession();
			session.setAttribute("user", admin);
			return "include/admin_login";
		}
		return "rest/login";
	}
	
	@GetMapping("/rest/logout")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "admin";
	}
}
