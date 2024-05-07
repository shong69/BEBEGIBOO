package com.bebegiboo.project.donate.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bebegiboo.project.donate.dto.DeliveryInfo;

@Mapper
public interface DonateMapper {

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
