package com.bebegiboo.project.mypage.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebegiboo.project.member.model.dto.Member;
import com.bebegiboo.project.mypage.model.mapper.UpdateMyInfoMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UpdateMyInfoServiceImpl implements UpdateMyInfoService{
	
	private final UpdateMyInfoMapper mapper; 
	
	private final BCryptPasswordEncoder bcrypt;
	
	/**
	 * 비밀번호 체크 
	 */
	@Override
	public int checkPw(Member loginMember) {
		
		String originPw = mapper.checkPw(loginMember.getMemberNo()); 
		String inputPw = loginMember.getMemberPw();
		
		if(!bcrypt.matches(inputPw, originPw)) {
			
			return 0; 
		}
		
		return 1;
	}


	
	
}
