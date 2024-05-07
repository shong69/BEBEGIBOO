package com.bebegiboo.project.donate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebegiboo.project.donate.dto.DeliveryInfo;
import com.bebegiboo.project.donate.service.DonateService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("donation")
@Slf4j
public class DonateContoller {
	
	private final DonateService service;

	@GetMapping("")
	public String Donation() {
		return "donation/donation-main";
	}
	
	@ResponseBody
	@PutMapping("complete")
	public int donationComplete(@RequestBody DeliveryInfo delivery,
									HttpServletRequest req,
									HttpServletResponse resp,
									Model model) {
		
		log.info("배송정보" + delivery);
		
		Cookie[] cookies = req.getCookies();
		

		String cookieValue = "";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginMember")) {
                    
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }
        /*
        log.info("로그인멤버 : " + cookieValue);
        
        int memberNo = service.findNo(cookieValue);
        
        delivery.setMemberNo(memberNo);
     	*/
        
        HttpSession session = req.getSession();
        
        session.setAttribute("delivery", delivery);

		return service.deliveryInfo(delivery);
		
	}
	
	@RequestMapping("completePage")
	public String completePage(HttpServletRequest req) {
		HttpSession session = req.getSession();
		log.info("모델" + session.getAttribute("delivery"));
		return "donation/donation-complete";
	}
	
}
