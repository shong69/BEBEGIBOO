package com.bebegiboo.project.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bebegiboo.project.donateInfo.dto.DonationProduct;
import com.bebegiboo.project.manager.mapper.ManagerMapper;
import com.bebegiboo.project.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService{
	
	private final ManagerMapper mapper;

	
	// 회원 목록 조회
	@Override
	public List<Member> selectMemberList() {

		return mapper.selectMemberList();
	}


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

}
