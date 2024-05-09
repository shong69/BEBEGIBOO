package com.bebegiboo.project.donationinfo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bebegiboo.project.donate.dto.Payment;
import com.bebegiboo.project.donateInfo.dto.DeliveryInfoList;
import com.bebegiboo.project.donateInfo.dto.DonationProduct;
import com.bebegiboo.project.donateInfo.dto.DonationRecord;
import com.bebegiboo.project.donateInfo.dto.ProductType;
import com.bebegiboo.project.donationinfo.model.service.DonationInfoService;
import com.bebegiboo.project.member.model.dto.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
@Controller
public class DonationInfoController {
	
	private final DonationInfoService service; 
	
	
	
	
	@GetMapping("mypage/donationInfo")
	public String donationInfoPage( HttpServletRequest req,
									HttpServletRequest resp, 
									@SessionAttribute("loginMember") Member loginMember,
									DeliveryInfoList delivery,
									DonationRecord record,
									DonationProduct product,
									@SessionAttribute("payment") Payment payment,
									HttpSession session) {
	
		
		int memberNo = loginMember.getMemberNo(); 
		
		List<DonationRecord> recordList = service.getDonationRecord(memberNo); 
		List<DeliveryInfoList> deliveryList = service.getDeliveryInfo(memberNo); 
		List<DonationProduct> productList = service.getProductInfo(memberNo); 

		
		
		log.info("record : " + recordList); 
		log.info("delivery : " + deliveryList ); 
		log.info("product : " + productList );


		
		
		
		
		return "member/mypage/donationInfo";
	}
	
	
	

}
