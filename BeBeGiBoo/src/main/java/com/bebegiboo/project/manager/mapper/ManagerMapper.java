package com.bebegiboo.project.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bebegiboo.project.donateInfo.dto.DonationProduct;
import com.bebegiboo.project.donateInfo.dto.DonationRecord;
import com.bebegiboo.project.member.model.dto.Member;

@Mapper
public interface ManagerMapper {

	/** 회원 목록 출력
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
	List<DonationRecord> selectDonationThingsList(int memberNo);

}
