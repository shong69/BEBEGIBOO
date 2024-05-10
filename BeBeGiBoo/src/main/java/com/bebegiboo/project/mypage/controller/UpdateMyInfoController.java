package com.bebegiboo.project.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bebegiboo.project.member.model.dto.Member;
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
	private String checkPwPage() {
		
		return "/member/mypage/checkPw"; 
		
	}
	
	/** 수정 페이지 이동 
	 * @return
	 */
	@GetMapping("updateMyInfo")
	private String updateInfoPage() {
		
		return "/member/mypage/updateMyInfo"; 
	}
	
	/** 비밀번호 체크 
	 * @param loginMember
	 * @param model
	 * @param ra
	 * @return
	 */
	@PostMapping("checkPw")
	private String checkPw( @SessionAttribute("loginMember") Member loginMember,
							Model model,
							RedirectAttributes ra) {
		
		int memberNo = loginMember.getMemberNo(); 
		String memberPw = loginMember.getMemberPw(); 
		
		loginMember.setMemberNo(memberNo);
		loginMember.setMemberPw(memberPw);
		
		int result = service.checkPw(loginMember); 
		
		String path = null; 
		String message = null; 
		
		if(result > 0) {
			
			message = "비밀번호 체크 성공!";
			path = "/member/mypage/updateMyInfo";
			
		}
		else {
			path ="redirect:/member/mypage/checkPw"; 
			message = "비밀번호가 일치하지 않습니다..";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}

}
