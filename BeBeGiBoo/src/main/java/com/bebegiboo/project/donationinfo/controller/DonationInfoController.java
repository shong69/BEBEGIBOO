package com.bebegiboo.project.donationinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RequestMapping("member")
@Controller
public class DonationInfoController {
	
	@GetMapping("mypage/donationInfo")
	public String donationInfoPage( HttpServletRequest req ) {
		
		HttpSession session = req.getSession();
		
		return "/member/mypage/donationInfo";
	}
	
	
	

}
