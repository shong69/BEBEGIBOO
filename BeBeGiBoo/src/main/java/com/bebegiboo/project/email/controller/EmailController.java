package com.bebegiboo.project.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebegiboo.project.email.model.service.EmailService;

import lombok.RequiredArgsConstructor;

@RequestMapping("email")
@RequiredArgsConstructor
@Controller
public class EmailController {
	
	private final EmailService service; 
	
	
	@ResponseBody
	@PostMapping("signup")
	public int signup(@RequestBody String email) {
		
		String authKey = service.sendEmail("signup", email);
		
		return 0; 
		
	}
	
	
	

}
