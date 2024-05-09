package com.bebegiboo.project.review.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebegiboo.project.review.model.dto.Comment;
import com.bebegiboo.project.review.model.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	private final CommentMapper mapper;
	//답글 달기
	@Override
	public int insert(Comment comment) {
		
		return mapper.insert(comment);
	}
	
	//댓글 삭제
	@Override
	public int delete(int commentNo) {
		
		return mapper.delete(commentNo);
	}

	//댓글 업데이트
	@Override
	public int udpate(Comment comment) {
		
		return mapper.update(comment);
	}

}
