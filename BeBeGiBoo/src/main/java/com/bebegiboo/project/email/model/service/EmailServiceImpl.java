package com.bebegiboo.project.email.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebegiboo.project.email.model.mapper.EmailMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class EmailServiceImpl implements EmailService {
	
	private final EmailMapper mapper;

	@Override
	public String sendEmail(String string, String email) {
		// TODO Auto-generated method stub
		return null;
	} 

}
