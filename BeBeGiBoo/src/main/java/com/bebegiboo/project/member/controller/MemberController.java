package com.bebegiboo.project.Member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebegiboo.project.member.model.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private com.bebegiboo.project.Member.model.service.MemberService service; 
	
	@GetMapping("signup")
	public String signup() {
		
		return "/member/signup/signup"; 
		
	}
	
	
	@ResponseBody
	@GetMapping("checkId")
	public int checkId( @RequestParam("memberId") String memberId) {
		
		return service.checkId(memberId); 
	}

}
