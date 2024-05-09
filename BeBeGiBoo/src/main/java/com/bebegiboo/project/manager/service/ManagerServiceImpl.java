package com.bebegiboo.project.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import com.bebegiboo.project.donateInfo.dto.DonationProduct;
>>>>>>> b0e1dfea78fcac5a7c2002b05087b270d1f19dfb
import com.bebegiboo.project.manager.mapper.ManagerMapper;
import com.bebegiboo.project.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService{
	
	private final ManagerMapper mapper;

	
<<<<<<< HEAD
	// 회원 목록 출력
=======
	// 회원 목록 조회
>>>>>>> b0e1dfea78fcac5a7c2002b05087b270d1f19dfb
	@Override
	public List<Member> selectMemberList() {

		return mapper.selectMemberList();
	}

<<<<<<< HEAD
=======

	// 회원 정보 수정
	@Override
	public int update(Member member) {

		return mapper.update(member);
	}


	// 기부물품 목록 조회
	@Override
	public List<DonationProduct> selectDonationThingsList() {

		return mapper.selectDonationThingsList();
	}

>>>>>>> b0e1dfea78fcac5a7c2002b05087b270d1f19dfb
}
