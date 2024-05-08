package com.bebegiboo.project.donate.service;

import org.springframework.stereotype.Service;

import com.bebegiboo.project.donate.dto.DeliveryInfo;
import com.bebegiboo.project.donate.dto.DonationThings;
import com.bebegiboo.project.donate.dto.Payment;
import com.bebegiboo.project.donate.mapper.DonateMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DonateServiceImpl implements DonateService{

	private final DonateMapper mapper;

	// loginMemberId로 MemberNo 찾기
	@Override
	public int findNo(String cookieValue) {		
		return mapper.findNo(cookieValue);
	}

	// 배송정보 삽입
	@Override
	public int deliveryInfo(DeliveryInfo delivery) {		
		return mapper.deliveryInfo(delivery);
	}

	// 기부물건 삽입
	@Override
	public int thingsInfo(DonationThings things) {

		String[] dailyArr = things.getDaily().split(",");
		String[] clothArr = things.getCloth().split(",");
		String[] dishArr = things.getDish().split(",");
		String[] electronicArr = things.getElectronic().split(",");
		String[] toyArr = things.getToy().split(",");
		log.info("비어있냐:" + dailyArr);
		
		int dailyNo = 0;
		if(dailyArr != null) {
			for(String dailyARR : dailyArr) {

				dailyNo = mapper.dailyInsert(dailyARR);
			}
		}
		
		int clothNo = 0;
		if(clothArr != null) {
			for(String clothARR : clothArr) {

				clothNo = mapper.clothInsert(clothARR);
			}
		}
		
		int dishNo = 0;
		if(dishArr != null) {
			for(String dishARR : dishArr) {

				dishNo = mapper.dishInsert(dishARR);
			}
		}
		
		int electronicNo = 0;
		if(electronicArr != null) {
			for(String electronicARR : electronicArr) {

				electronicNo = mapper.electronicInsert(electronicARR);
			}
		}
		
		int toyNo = 0;
		if(toyArr != null) {
			for(String toyARR : toyArr) {

				toyNo = mapper.toyInsert(toyARR);
			}
		}
	
		
		return dailyNo+clothNo+dishNo+electronicNo+toyNo;
	}

}
