package com.bebegiboo.project.donate.service;

import org.springframework.stereotype.Service;

import com.bebegiboo.project.donate.dto.DeliveryInfo;
import com.bebegiboo.project.donate.mapper.DonateMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
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
}
