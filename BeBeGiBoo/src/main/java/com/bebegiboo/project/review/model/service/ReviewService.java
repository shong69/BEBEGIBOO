package com.bebegiboo.project.review.model.service;

import java.util.Map;

public interface ReviewService {

	/** 검색X 후기 게시판 글 목록 불러오기
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectReviewList(int cp);

	/** 검색 O 후기 게시판 글 목록 불러오기
	 * @param paramMap
	 * @param cp
	 * @return
	 */
	Map<String, Object> searchList(Map<String, Object> paramMap, int cp);

}
