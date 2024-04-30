package com.bebegiboo.project.member.controller;

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
	private MemberService service; 
	
	/** 회원가입 화면 이동 
	 * @return
	 */
	@GetMapping("signup")
	public String signup() {
		
		return "/member/signup/signup"; 
		
	}
	
	/** 로그인 화면 이동 
	 * @return
	 */
	@GetMapping("login")
	public String login() {
		
		return "/member/login/login"; 
		
	}
	
	
	/** 아이디 중복 검사 
	 * @param memberId
	 * @return
	 */
	@ResponseBody
	@GetMapping("checkId")
	public int checkId(@RequestParam("memberId") String memberId) {
	    return service.checkId(memberId);
	}

	
	@ResponseBody
	@GetMapping("checkEmail")
	public int checkEmail(@RequestParam("email") String email) {
		return service.checkEmail(email); 
	}
	
	
	
	
	
}
