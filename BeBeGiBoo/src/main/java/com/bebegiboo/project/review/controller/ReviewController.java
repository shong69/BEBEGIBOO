package com.bebegiboo.project.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("review")
public class ReviewController {

	/** 전체 후기 목록 불러오기
	 * @return
	 */
	@GetMapping("")
	public String selectReview() {
		
		return "/review/review"; 
	}
}
