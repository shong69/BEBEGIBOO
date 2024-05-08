package com.bebegiboo.project.donate.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	public int thingsInfo(DonationThings things, int memberNo) {

		String[] dailyArr = things.getDaily().split(",");
		String[] clothArr = things.getCloth().split(",");
		String[] dishArr = things.getDish().split(",");
		String[] electronicArr = things.getElectronic().split(",");
		String[] toyArr = things.getToy().split(",");

		
		int dailyNo = 0;
		if(!Arrays.toString(dailyArr).equals("[]")) {
			for(String dailyARR : dailyArr) {
				
				Map<String, Object> dailymap = new HashMap<String, Object>();
				dailymap.put("dailyARR", dailyARR);
				dailymap.put("memberNo", memberNo);

				
				dailyNo = mapper.dailyInsert(dailymap);
			}
		}
		
		int clothNo = 0;
		if(!Arrays.toString(clothArr).equals("[]")) {
			for(String clothARR : clothArr) {

				Map<String, Object> dailymap = new HashMap<String, Object>();
				dailymap.put("clothARR", clothARR);
				dailymap.put("memberNo", memberNo);

				
				dailyNo = mapper.dailyInsert(dailymap);
			}
		}
		
		int dishNo = 0;
		if(!Arrays.toString(dishArr).equals("[]")) {
			for(String dishARR : dishArr) {

				Map<String, Object> dishMap = new HashMap<String, Object>();
				dishMap.put("dishARR", dishARR);
				dishMap.put("memberNo", memberNo);

				
				dishNo = mapper.dailyInsert(dishMap);
			}
		}
		
		int electronicNo = 0;
		if(!Arrays.toString(electronicArr).equals("[]")) {
			for(String electronicARR : electronicArr) {

				Map<String, Object> electronicMap = new HashMap<String, Object>();
				electronicMap.put("electronicARR", electronicARR);
				electronicMap.put("memberNo", memberNo);

				
				electronicNo = mapper.dailyInsert(electronicMap);
			}
		}
		
		int toyNo = 0;
		if(!Arrays.toString(toyArr).equals("[]")) {
			for(String toyARR : toyArr) {

				Map<String, Object> toyMap = new HashMap<String, Object>();
				toyMap.put("toyARR", toyARR);
				toyMap.put("memberNo", memberNo);

				
				toyNo = mapper.dailyInsert(toyMap);
			}
		}
	
		
		return dailyNo+clothNo+dishNo+electronicNo+toyNo;
	}

	// 기부기록정보 삽입
	@Override
	public int recordInfo(int memberNo) {
		
		return mapper.recordInfo(memberNo);
	}

}
