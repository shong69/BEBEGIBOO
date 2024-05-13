package com.bebegiboo.project.acceptor.service;

import java.util.List;

import com.bebegiboo.project.donateInfo.dto.DonationRecord;

public interface AcceptorService {

	/** 기부물품 목록 조회
	 * @return
	 */
	List<DonationRecord> selectProduct();

}
