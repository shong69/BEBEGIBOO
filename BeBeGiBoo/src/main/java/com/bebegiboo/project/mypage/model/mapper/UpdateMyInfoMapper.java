package com.bebegiboo.project.mypage.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bebegiboo.project.member.model.dto.Member;

@Mapper
public interface UpdateMyInfoMapper {

	/** 비밀번호 대조 
	 * @param memberNo
	 * @return
	 */
	String checkPw(int memberNo);
	

}
