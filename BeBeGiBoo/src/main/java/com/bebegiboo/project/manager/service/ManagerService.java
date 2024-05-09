package com.bebegiboo.project.manager.service;

import java.util.List;

import com.bebegiboo.project.member.model.dto.Member;

public interface ManagerService {

	/** 회원 목록 출력
	 * @return
	 */
	List<Member> selectMemberList();

}
