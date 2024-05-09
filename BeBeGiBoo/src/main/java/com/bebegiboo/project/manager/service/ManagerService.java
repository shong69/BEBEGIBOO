package com.bebegiboo.project.manager.service;

import java.util.List;

<<<<<<< HEAD
=======
import com.bebegiboo.project.donateInfo.dto.DonationProduct;
>>>>>>> b0e1dfea78fcac5a7c2002b05087b270d1f19dfb
import com.bebegiboo.project.member.model.dto.Member;

public interface ManagerService {

<<<<<<< HEAD
	/** 회원 목록 출력
=======
	/** 회원 목록 조회
>>>>>>> b0e1dfea78fcac5a7c2002b05087b270d1f19dfb
	 * @return
	 */
	List<Member> selectMemberList();

<<<<<<< HEAD
=======
	/** 회원 정보 수정
	 * @param member
	 * @return
	 */
	int update(Member member);

	/** 기부물품 목록 조회
	 * @return
	 */
	List<DonationProduct> selectDonationThingsList();

>>>>>>> b0e1dfea78fcac5a7c2002b05087b270d1f19dfb
}
