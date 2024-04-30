package com.bebegiboo.project.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bebegiboo.project.member.model.dto.Member;

@Mapper
public interface MemberMapper{

	/** 회원 로그인
	 * @param memberId
	 * @return
	 */
	Member login(String memberId);

}
