package com.bebegiboo.project.certification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("certification")
public class CertificationController {

	@GetMapping("")
	public String certification() {
		return "applyCertification";
	}
}
