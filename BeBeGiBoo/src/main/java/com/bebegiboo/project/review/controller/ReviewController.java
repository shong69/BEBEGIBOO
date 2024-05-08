package com.bebegiboo.project.review.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebegiboo.project.review.model.service.ReviewService;

import lombok.RequiredArgsConstructor;

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
	public String selectReview(
			@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			Model model,
			@RequestParam Map<String, Object> paramMap
			) {
		
		Map<String, Object> map = null;
		/*
		if(paramMap.get("key") == null) { //검색 X
			map = service.selectReviewList(cp);
		} else { //검색 O
			
			map = service.searchList(paramMap, cp);
		}
		*/
		model.addAttribute("reviewList", map.get("reviewList"));
		model.addAttribute("pagination", map.get("pagination"));
		
		return "/review/review"; 
	}
}
