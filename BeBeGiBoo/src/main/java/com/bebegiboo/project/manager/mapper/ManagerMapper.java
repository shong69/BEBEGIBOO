package com.bebegiboo.project.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bebegiboo.project.member.model.dto.Member;

@Mapper
public interface ManagerMapper {

	/** 회원 목록 출력
	 * @return
	 */
	List<Member> selectMemberList();

}
