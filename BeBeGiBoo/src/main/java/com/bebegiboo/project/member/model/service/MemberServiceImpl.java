package com.bebegiboo.project.member.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bebegiboo.project.member.model.dto.Member;
import com.bebegiboo.project.member.model.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberMapper mapper;
	
	private final BCryptPasswordEncoder bcrypt;
	@Override
	public int checkId(String memberId) {
		// TODO Auto-generated method stub
		return 0;
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
