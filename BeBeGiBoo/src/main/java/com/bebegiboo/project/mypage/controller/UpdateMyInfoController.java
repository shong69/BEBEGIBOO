package com.bebegiboo.project.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bebegiboo.project.mypage.model.service.UpdateMyInfoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("member/mypage")
@Controller
public class UpdateMyInfoController {
	
	private final UpdateMyInfoService service; 
	
	/** 비밀번호 체크 창 이동 
	 * @return
	 */
	@GetMapping("checkPw")
	private String checkPw() {
		
		return "/member/mypage/checkPw"; 
		
	}
	
	@GetMapping("updateMyInfo")
	private String updateInfo() {
		
		return "/member/mypage/updateMyInfo"; 
	}

}
