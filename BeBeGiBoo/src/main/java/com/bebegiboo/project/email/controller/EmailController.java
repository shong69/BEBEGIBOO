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
		
		if(authKey != null) { // 인증번호가 반환되서 돌아옴
			// == 이메일 보내기 성공
			return 1;
		}

		// 이메일 보내기 실패
		return 0;
	}
	
	
	

}
