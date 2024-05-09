package com.bebegiboo.project.manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebegiboo.project.donateInfo.dto.DonationProduct;
import com.bebegiboo.project.manager.service.ManagerService;
import com.bebegiboo.project.member.model.dto.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("manager")
@RequiredArgsConstructor
@Slf4j
public class ManagerController {
	
	private final ManagerService service;
	
	
	

	/** 회원관리 페이지 이동
	 * @return
	 */
	@GetMapping("membership")
	public String memberShip() {
		return "/manager/membership";
	}
	
	/** 기부물품관리 페이지 이동
	 * @return
	 */
	@GetMapping("donationThings")
	public String donationThings() {
		return "/manager/donationThings";
	}
	
	
	/** 회원 목록 조회
	 * @return
	 */
	@ResponseBody
	@GetMapping("selectMemberList")
	public List<Member> selectMemberList() {
		List<Member> memberList = service.selectMemberList();
		
		return memberList;
	}
	
	
	/** 회원정보 수정
	 * @return
	 */
	@PutMapping("update")
	@ResponseBody
	public int update(@RequestBody Member member) {
		log.info("멤버" + member);
		
		int result = service.update(member);
		
		return result;
	}
	
	
	/** 기부물품 목록 조회
	 * @return
	 */
	@ResponseBody
	@GetMapping("selectDonationThings")
	public List<DonationProduct> selectDonationThingsList() {
		List<DonationProduct> donationThingsList = service.selectDonationThingsList();
		
		return donationThingsList;
	}
}
