package com.bebegiboo.project.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manager")
public class ManagerController {

	@GetMapping("main")
	public String main() {
		return "/manager/manager-main";
	}
}
