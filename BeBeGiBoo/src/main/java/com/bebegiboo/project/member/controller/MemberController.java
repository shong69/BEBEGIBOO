package com.bebegiboo.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bebegiboo.project.member.model.dto.Member;
import com.bebegiboo.project.member.model.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service; 
	
	/** 회원가입 화면 이동 
	 * @return
	 */
	@GetMapping("signup/signupMain")
	public String signupMain() {
		
		return "/member/signup/signupMain"; 
	}
	
	/** 회원가입 폼 화면 이동 
	 * @return
	 */
	@GetMapping("signup/signupForm")
	public String signupForm() {
		return "/member/signup/signupForm"; 
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
	
	
	@PostMapping("login")
	public String login(Member inputMember,
						RedirectAttributes ra,
						Model model,
						@RequestParam(value="name", required=false) String saveId,
						HttpServletResponse resp
						) {
		
		
		Member loginMember = service.login(inputMember);
		String message=null;
		String path= null;
		if(loginMember == null) {
			
			message="아이디 또는 비밀번호가 일치하지 않습니다";
			path ="/member/login/login";
		}else {
			
			model.addAttribute("loginMember", loginMember);
			
			//쿠키 만들기
			Cookie cookie = new Cookie("saveId", loginMember.getMemberId());
			
			cookie.setPath("/"); 
			
			if(saveId != null) {
				cookie.setMaxAge(60*60*24*30);
				
			}else {
				cookie.setMaxAge(0); //기존 쿠키 삭제
			}
			
			resp.addCookie(cookie);
			
			ra.addFlashAttribute("message", message);
			
			path ="redirect:/";
			
		}
		
		return path;
	}

	
	@ResponseBody
	@GetMapping("checkEmail")
	public int checkEmail(@RequestParam("email") String email) {
		return service.checkEmail(email); 
	}
	
	
	
	
	
}
