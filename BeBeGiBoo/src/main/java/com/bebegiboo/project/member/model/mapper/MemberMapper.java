package com.bebegiboo.project.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	/** 아이디 중복 체크 
	 * @param memberId
	 * @return result 
	 */
	int checkId(String memberId);

	/** 이메일 중복 체크 
	 * @param email
	 * @return result 
	 */
	int checkEmail(String email);

}
