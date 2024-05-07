package com.bebegiboo.project.donate.service;

import org.springframework.stereotype.Service;

import com.bebegiboo.project.donate.dto.DeliveryInfo;

@Service
public interface DonateService {

	/** loginMemberId로 MemberNo 찾기
	 * @param cookieValue
	 * @return
	 */
	int findNo(String cookieValue);

	/** 배송정보 삽입
	 * @param delivery
	 * @return
	 */
	int deliveryInfo(DeliveryInfo delivery);

}
