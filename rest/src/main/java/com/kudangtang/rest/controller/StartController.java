package com.kudangtang.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StartController {
	@GetMapping({"/", "/start"})
	public String home() {
		return "start";
	}
}
