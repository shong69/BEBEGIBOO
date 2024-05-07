package com.bebegiboo.project.donate.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebegiboo.project.donate.dto.DeliveryInfo;
import com.bebegiboo.project.donate.dto.DonationThings;
import com.bebegiboo.project.donate.dto.Payment;
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
	public int donationComplete(@RequestBody Map<String, Object> obj,
									HttpServletRequest req,
									HttpServletResponse resp,
									Model model) {
		
		log.info("정보" + obj);
		
		DonationThings things = new DonationThings((String)obj.get("daily"),
													(String)obj.get("cloth"),
													(String)obj.get("dish"),
													(String)obj.get("electronic"),
													(String)obj.get("toy"));
		
		log.info("물건들" + things);
		
		DeliveryInfo delivery = new DeliveryInfo((String)obj.get("name"),
												(String)obj.get("phone"),
												(String)obj.get("phone2"),
												(String)obj.get("address"),
												(String)obj.get("date"),
												(String)obj.get("memo"),
												1);
		
		log.info("배송정보들" + delivery);
		
		Payment payment = new Payment(Integer.parseInt(String.valueOf(obj.get("total"))),
										(String) obj.get("payment"));
		
		log.info("계산" + payment);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(Integer.valueOf((String)obj.get("dailyBox")) != 0) {
			map.put("생활용품", Integer.valueOf((String)obj.get("dailyBox")));
		}
		if(Integer.valueOf((String)obj.get("clothBox")) != 0) {
			map.put("의류", Integer.valueOf((String)obj.get("clothBox")));
		}
		if(Integer.valueOf((String)obj.get("dishBox")) != 0) {
			map.put("식기", Integer.valueOf((String)obj.get("dishBox")));
		}
		if(Integer.valueOf((String)obj.get("electronicBox")) != 0) {
			map.put("가전", Integer.valueOf((String)obj.get("electronicBox")));
		}
		if(Integer.valueOf((String)obj.get("toyBox")) != 0) {
			map.put("장난감", Integer.valueOf((String)obj.get("toyBox")));
		}
        
        HttpSession session = req.getSession();
        
        session.setAttribute("things", things);
        session.setAttribute("delivery", delivery);
        session.setAttribute("payment", payment);
        session.setAttribute("boxCount", map);
        
        int thingsNo = service.thingsInfo(things);
        int deliveryNo = service.deliveryInfo(delivery);

		return thingsNo + deliveryNo;
		
	}
	
	@RequestMapping("completePage")
	public String completePage(HttpServletRequest req) {
		HttpSession session = req.getSession();
		log.info("모델1" + session.getAttribute("things"));
		log.info("모델2" + session.getAttribute("delivery"));
		log.info("모델3" + session.getAttribute("payment"));
		return "donation/donation-complete";
	}
	
}
