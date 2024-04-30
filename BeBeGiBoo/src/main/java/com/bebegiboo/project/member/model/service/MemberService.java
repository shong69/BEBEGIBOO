package com.bebegiboo.project.member.model.service;

import com.bebegiboo.project.member.model.dto.Member;

public interface MemberService {

	int checkId(String memberId);

	/**회원 로그인
	 * @param inputMember
	 * @return
	 */
	Member login(Member inputMember);

}
