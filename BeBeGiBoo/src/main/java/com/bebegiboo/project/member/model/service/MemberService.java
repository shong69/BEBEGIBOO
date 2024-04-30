package com.bebegiboo.project.member.model.service;

public interface MemberService {

	/** 아이디 중복 체크 
	 * @param memberId
	 * @return result 
	 */
	int checkId(String memberId);

	/** 이메일 중복 검사 
	 * @param email
	 * @return
	 */
	int checkEmail(String email);

}
