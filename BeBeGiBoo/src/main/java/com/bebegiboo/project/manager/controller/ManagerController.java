package com.bebegiboo.project.manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebegiboo.project.manager.service.ManagerService;
import com.bebegiboo.project.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("manager")
@RequiredArgsConstructor
public class ManagerController {
	
	private final ManagerService service;
	
	
	

	/** 회원관리페이지 이동
	 * @return
	 */
	@GetMapping("membership")
	public String main() {
		return "/manager/membership";
	}
	
	
	/** 회원 목록 출력
	 * @return
	 */
	@ResponseBody
	@GetMapping("selectMemberList")
	public List<Member> selectMemberList() {
		List<Member> memberList = service.selectMemberList();
		
		return memberList;
	}
}
