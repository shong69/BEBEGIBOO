package com.bebegiboo.project.acceptor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebegiboo.project.acceptor.service.AcceptorService;
import com.bebegiboo.project.donateInfo.dto.DonationRecord;
import com.bebegiboo.project.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("acceptor")
@RequiredArgsConstructor
public class AcceptorController {
	
	private final AcceptorService service;

	/** 기부물품 신청 메인페이지 이동
	 * @return
	 */
	@GetMapping("main")
	public String acceptorMain() {
		return "/acceptor/acceptor-main";
	}
	
	/** 기부물품 목록 조회
	 * @return
	 */
	@ResponseBody
	@GetMapping("selectproductList")
	public List<DonationRecord> selectproductList() {
		List<DonationRecord> productList = service.selectProduct();

		
		return productList;
	}
}
