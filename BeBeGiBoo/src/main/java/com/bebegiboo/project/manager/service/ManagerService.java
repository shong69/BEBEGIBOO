package com.bebegiboo.project.manager.service;

import java.util.List;

import com.bebegiboo.project.donateInfo.dto.DonationProduct;
import com.bebegiboo.project.member.model.dto.Member;

public interface ManagerService {

	/** 회원 목록 조회
	 * @return
	 */
	List<Member> selectMemberList();

	/** 회원 정보 수정
	 * @param member
	 * @return
	 */
	int update(Member member);

	/** 기부물품 목록 조회
	 * @return
	 */
	List<DonationProduct> selectDonationThingsList();

}
