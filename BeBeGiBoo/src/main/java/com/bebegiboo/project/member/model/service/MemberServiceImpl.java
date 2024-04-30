package com.bebegiboo.project.member.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bebegiboo.project.member.model.dto.Member;

import com.bebegiboo.project.member.model.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;




@Transactional
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberMapper mapper;
	
	private final BCryptPasswordEncoder bcrypt;
	


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

	//회원 로그인
	@Override
	public Member login(Member inputMember) {
		
		Member loginMember = mapper.login(inputMember.getMemberId());
		
		if(loginMember == null) {
			return null;
		}
		if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
			return null;
		}
		
		loginMember.setMemberPw(null);
		return loginMember;
	}

}
