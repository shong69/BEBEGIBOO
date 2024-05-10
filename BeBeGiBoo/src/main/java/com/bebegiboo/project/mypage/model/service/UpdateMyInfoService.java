package com.bebegiboo.project.mypage.model.service;

import com.bebegiboo.project.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

public interface UpdateMyInfoService {

	/** 비밀번호 대조 
	 * @param loginMember
	 * @return
	 */
	int checkPw(Member loginMember);

}
