package com.bebegiboo.project.donate.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bebegiboo.project.donate.dto.DeliveryInfo;
import com.bebegiboo.project.donate.dto.DonationThings;
import com.bebegiboo.project.donate.dto.Payment;

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

	/** daily
	 * @param arr
	 * @return
	 */
	int dailyInsert(String dailyARR);

	/** cloth
	 * @param arr
	 * @return
	 */
	int clothInsert(String clothARR);

	/** dish
	 * @param arr
	 * @return
	 */
	int dishInsert(String dishARR);

	/** electronic
	 * @param arr
	 * @return
	 */
	int electronicInsert(String electronicARR);

	/** toy
	 * @param arr
	 * @return
	 */
	int toyInsert(String toyARR);


}
