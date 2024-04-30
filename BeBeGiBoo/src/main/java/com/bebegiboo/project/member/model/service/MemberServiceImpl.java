package com.bebegiboo.project.member.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebegiboo.project.member.model.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Transactional
@Service
public class MemberServiceImpl implements MemberService {
	
	
	private final MemberMapper mapper; 
	
	

	/**
	 * 아이디 중복 체크 
	 */
	@Override
	public int checkId(String memberId) {
		
		return mapper.checkId(memberId);
	}



	/**
	 * 이메일 중복 체크 
	 */
	@Override
	public int checkEmail(String email) {
		
		return mapper.checkEmail(email);
	}

}
