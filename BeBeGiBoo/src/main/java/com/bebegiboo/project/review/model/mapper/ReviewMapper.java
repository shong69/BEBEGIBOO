package com.bebegiboo.project.review.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.bebegiboo.project.certification.model.dto.Certification;
@Mapper
public interface ReviewMapper {

	/** 리뷰 개수 세기
	 * @return
	 */
	int getListCount();

	/** 리뷰 목록 반환하기
	 * @param rowBounds
	 * @return
	 */
	List<Certification> SelectReivewList(RowBounds rowBounds);

	/** 검색된 게시물 개수 
	 * @param paramMap
	 * @return
	 */
	int getSearchCount(Map<String, Object> paramMap);

	/** 검색된 게시물 목록 반환하기
	 * @param paramMap
	 * @param rowBounds
	 * @return
	 */
	List<Certification> selectSearchList(Map<String, Object> paramMap, RowBounds rowBounds);

}
