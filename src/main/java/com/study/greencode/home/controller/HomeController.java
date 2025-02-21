package com.study.greencode.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/greencode")
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "/greencode/home";
	}
}
