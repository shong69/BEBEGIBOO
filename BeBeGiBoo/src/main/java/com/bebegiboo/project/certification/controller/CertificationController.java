package com.bebegiboo.project.certification.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bebegiboo.project.certification.model.dto.Certification;
import com.bebegiboo.project.certification.model.dto.CertificationImg;
import com.bebegiboo.project.certification.model.service.CertificationService;
import com.bebegiboo.project.member.model.dto.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("certification")
@Controller
public class CertificationController {
	
	private final CertificationService service; 
	
	

	/** 인증신청 폼 화면 이동 
	 * @return
	 */
	@GetMapping("certification")
	public String certificationMain() {
		
		return "/certification/certification"; 
		
	}
	

	/** 인증 신청 폼 제출 
	 * @param memberAddress
	 * @param inputCertification
	 * @param loginMember
	 * @param model
	 * @param ra
	 * @param images
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@PostMapping("certification")
	public String certificationSubmit(@RequestParam("address") String[] memberAddress,
										Certification inputCertification,
										@SessionAttribute("loginMember") Member loginMember,
										Model model, 
										RedirectAttributes ra, 
										@RequestParam("images") List<MultipartFile> images ) throws IllegalStateException, IOException {
		
		log.debug("images : ", images);
		
		inputCertification.setMemberNo(loginMember.getMemberNo());
		
		int result = service.certificationSubmit(inputCertification, memberAddress, images); 
		
		
		
		
		String path; 
		String message; 
		
		if(result > 0) {
			message = "신청완료"; 
			path = "/";    // 완료 화면으로 변경 
		} else {
			message = "신청 실패.."; 
			path = "certification/certification"; 
		}
		
		ra.addFlashAttribute("message",message); 
		
		return "redirect:" + path; 
		
		
	}
	
	
}