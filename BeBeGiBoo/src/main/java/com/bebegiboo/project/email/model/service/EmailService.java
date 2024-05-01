package com.bebegiboo.project.email.model.service;

public interface EmailService {

	/** 인증 메일 보내기 서비스 
	 * @param string
	 * @param email
	 * @return
	 */
	String sendEmail(String string, String email);

}
