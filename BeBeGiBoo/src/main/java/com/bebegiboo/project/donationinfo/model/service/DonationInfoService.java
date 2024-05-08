package com.bebegiboo.project.donationinfo.model.service;

import java.util.List;

import com.bebegiboo.project.donateInfo.dto.DeliveryInfoList;
import com.bebegiboo.project.donateInfo.dto.DonationProduct;
import com.bebegiboo.project.donateInfo.dto.DonationRecord;



public interface DonationInfoService {

	/** 기부 내역 레코드 조회 
	 * @param memberNo
	 * @return
	 */
	List<DonationRecord> getDonationRecord(int memberNo);

	/** 배송 정보 조회 
	 * @param memberNo
	 * @return
	 */
	List<DeliveryInfoList> getDeliveryInfo(int memberNo);

	/** 기부 물품 조회 
	 * @param memberNo
	 * @return
	 */
	List<DonationProduct> getProductInfo(int memberNo);


}
