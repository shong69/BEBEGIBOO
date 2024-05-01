package com.bebegiboo.project.member.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bebegiboo.project.member.model.dto.Member;

import com.bebegiboo.project.member.model.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	



	/**
	 * 아이디 중복 체크 
	 */

	private final MemberMapper mapper;
	
	private final BCryptPasswordEncoder bcrypt;

  
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
		log.debug("pw : "+bcrypt.encode("1q2w3e4r"));
		Member loginMember = mapper.login(inputMember.getMemberId());
		
		if(loginMember == null) {
			return null;
		}
		if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
			log.debug("pw틀림");
			return null;
		}
		
		
		loginMember.setMemberPw(null);
		return loginMember;
	}

}
