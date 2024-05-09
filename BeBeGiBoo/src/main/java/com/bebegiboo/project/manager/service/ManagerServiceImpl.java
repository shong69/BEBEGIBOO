package com.bebegiboo.project.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bebegiboo.project.manager.mapper.ManagerMapper;
import com.bebegiboo.project.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService{
	
	private final ManagerMapper mapper;

	
	// 회원 목록 출력
	@Override
	public List<Member> selectMemberList() {

		return mapper.selectMemberList();
	}

}
