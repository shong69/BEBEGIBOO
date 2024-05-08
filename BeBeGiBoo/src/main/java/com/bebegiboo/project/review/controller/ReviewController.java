package com.bebegiboo.project.review.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebegiboo.project.review.model.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService service;
	/** 후기 게시판 목록 조회
	 * @param cp
	 * @param model
	 * @return
	 */
	@GetMapping("")
	public String selectBoard(
			@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			Model model,
			@RequestParam Map<String, Object> paramMap
			) {
		log.debug("map : "+paramMap); //map : {key=t, query=}
		
		Map<String, Object> map = null;


		
		if(paramMap.get("key") == null) { //검색 X(그냥 목록 조회)

			map = service.selectReviewList(cp);
			
		}else { //검색 O
			//검색 내용이 없는 경우 그냥 리턴하고 전체 목록 보여주기
			if(paramMap.get("query")== null) {
				return "/review/review";
			}
			map = service.searchList(paramMap, cp);
			
			
		}

		model.addAttribute("reviewList", map.get("reviewList"));
		model.addAttribute("pagination", map.get("pagination"));
		
		return "/review/review"; 
	}
	
	
	
	
	
	
}
